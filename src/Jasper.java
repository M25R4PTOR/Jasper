import java.security.SecureRandom;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

public class Jasper {

	public static void main(String[] args) {
		SecureRandom randon = new SecureRandom();
		
		String plantillaJasper = args[0];
		String datosXml = args[1];
		String path = args[2];

		String nombrePdf = "documento_" + Math.abs(randon.nextInt()) + ".pdf";
		
		try {
			JRXmlDataSource xmlDataSource = new JRXmlDataSource(datosXml, path);

			JasperPrint jasperPrint = JasperFillManager.fillReport(plantillaJasper, new HashMap(), xmlDataSource);

			JasperExportManager.exportReportToPdfFile(jasperPrint, nombrePdf);

		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
