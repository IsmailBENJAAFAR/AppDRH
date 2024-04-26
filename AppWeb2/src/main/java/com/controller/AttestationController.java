package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.entities.Stagiere;
import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.session.StagiereSessionLocal;


@ManagedBean
@SessionScoped
public class AttestationController {
	@EJB
	private StagiereSessionLocal stagiereLocal;
	private String idStagiere;
	
	public String getIdStagiere() {
		return idStagiere;
	}
	public void setIdStagiere(String idStagiere) {
		this.idStagiere = idStagiere;
	}
	public AttestationController() {}
	//create pdf
	public void createAttestation() {
		
	}
	//download pdf
	public void downloadAttestation() throws IOException {
		Stagiere s = stagiereLocal.getStagiere(Integer.parseInt(idStagiere));
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		String masterPath = facesContext.getExternalContext().getRealPath( "/WEB-INF/Attestation.pdf" );
        response.setContentType( "application/pdf" );
        facesContext.responseComplete();
        facesContext.renderResponse();
        try ( PdfReader reader = new PdfReader( masterPath );
              PdfWriter writer = new PdfWriter( response.getOutputStream() );
              PdfDocument document = new PdfDocument( reader, writer ) ) {
            
            PdfPage page = document.getPage( 1 );
            PdfCanvas canvas = new PdfCanvas( page );
            
            FontProgram fontProgram = FontProgramFactory.createFont();
            PdfFont font = PdfFontFactory.createFont( fontProgram, "UTF-8" , true);
            canvas.setFontAndSize( font, 14 );
            
            canvas.beginText();
         
            canvas.setTextMatrix( 70, 625 );
            canvas.showText( "Je soussigné Monsieur "+s.getStage().getEncadrant().getNom()+" "+s.getStage().getEncadrant().getPrenom()+", agissant en qualité de Directeur " );
            canvas.setTextMatrix( 70, 605 );
            canvas.showText( "géneral, certifie par la présente que Monsieur "+s.getNom()+" "+s.getPrenom()+" demeurant au ");
            canvas.setTextMatrix( 70, 585 );
            canvas.showText( s.getAdresse()+" a effectué un stage au sein du departement "+ s.getStage().getDepartement().getNom());
            canvas.setTextMatrix( 70, 565 );
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
            canvas.showText( "de notre école Ensa Khouribga pour une période allant du "+df.format(s.getStage().getDateDebut()));
            canvas.setTextMatrix( 70, 545 );
            canvas.showText( "au "+df.format(s.getStage().getDateFin()));
            
            canvas.setTextMatrix( 70, 515 );
            canvas.showText( "Cette attestation est délivrée à l’intéressé(e) pour servir et valoir ce que de droit." );
            
            canvas.setTextMatrix( 70, 445 );
            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
            String strDate = dateFormat.format(date); 
            canvas.showText( "Fait a Oujda le,"+ strDate);
            
            canvas.setTextMatrix( 70, 390 );
            canvas.showText( "Signature : " );
            
            canvas.setTextMatrix( 70, 340);
            canvas.showText( "Cachet de l’entreprise " );
            
            
            
            canvas.endText();
            
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
