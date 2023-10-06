package Default;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
// --- <<IS-END-IMPORTS>> ---

public final class FlowServices

{
	// ---( internal utility methods )---

	final static FlowServices _instance = new FlowServices();

	static FlowServices _newInstance() { return new FlowServices(); }

	static FlowServices _cast(Object o) { return (FlowServices)o; }

	// ---( server methods )---




	public static final void convertPDF1 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertPDF1)>> ---
		// @sigtype java 3.5
		String htmlFilePath = "C:\\Users\\hp\\Downloads\\pdfHtmlCode.html";
		String pdfFilePath = "C:\\testingclone\\output.pdf";
		
		 
		
		try {
		    // Create a new PDF document
		    PDDocument document = new PDDocument();
		
		 
		
		    // Create a new page
		    PDPage page = new PDPage(PDRectangle.A4);
		    document.addPage(page);
		
		 
		
		    // Load the HTML content into the PDF using PDFTextStripper
		    PDFTextStripper stripper = new PDFTextStripper();
		    String htmlText = "Your HTML content as a string"; // You can read the HTML content from a file or any source
		    stripper.setSortByPosition(true);
		    stripper.setStartPage(1);
		    stripper.setEndPage(1);
		    stripper.getText(new PDDocument(), htmlText);
		
		 
		
		    // Save the PDF document
		    document.save(pdfFilePath);
		
		 
		
		    // Close the PDF document
		    document.close();
		
		 
		
		    System.out.println("HTML to PDF conversion completed successfully.");
		} catch (IOException e) {
		    e.printStackTrace();
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void convertpdf (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertpdf)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputText
		// [i] field:0:required outputPath
    IDataCursor cursor = pipeline.getCursor();
    
    try {
        String inputText = IDataUtil.getString(cursor, "inputText");
        String outputPath = IDataUtil.getString(cursor, "outputPath");
        Document document = new Document();
        PdfWriter.getInstance(document, new java.io.FileOutputStream(outputPath));
        document.open();
        document.add(new Paragraph(inputText));
        document.close();
        IDataUtil.put(cursor, "outputPath", outputPath);
    } catch (Exception e) {
        e.printStackTrace(); 
    } finally {
        cursor.destroy();
    }




	
		// --- <<IS-END>> ---

                
	}



	public static final void convertpdf_1 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(convertpdf_1)>> ---
		// @sigtype java 3.5
		// [i] field:0:required htmlContent
		// [i] field:0:required outputPath
   IDataCursor cursor = pipeline.getCursor();

    try {
        // Get the HTML content as a string from the pipeline
        String htmlContent = IDataUtil.getString(cursor, "htmlContent");
        String outputPath = IDataUtil.getString(cursor, "outputPath");

        // Create a Document
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));
        document.open();

        // Use XMLWorkerHelper to parse the HTML and add it to the PDF
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlContent.getBytes()));

        document.close();
        IDataUtil.put(cursor, "outputPath", outputPath);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        cursor.destroy();
    }
   
    






	
		// --- <<IS-END>> ---

                
	}



	public static final void java (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(java)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputText
		// [i] field:0:required outputPath
   IDataCursor cursor = pipeline.getCursor();
    try {
        String inputText = IDataUtil.getString(cursor, "inputText");
        String outputPath = IDataUtil.getString(cursor, "outputPath");
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));
        document.open();

        // Create an instance of HTMLWorker
        HTMLWorker htmlWorker = new HTMLWorker(document);

        // Parse and render the HTML content to the PDF
        htmlWorker.parse(new StringReader(inputText));

        document.close();
        System.out.println("HTML to PDF conversion completed successfully.");
    } catch (Exception e) {
        e.printStackTrace();
    }
	
		// --- <<IS-END>> ---

                
	}
}

