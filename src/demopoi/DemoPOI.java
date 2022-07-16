package demopoi;

import demopoi.dao.Negocio;
import demopoi.model.Products;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author cjuan
 */
public class DemoPOI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String fileName = "Productos.xlsx";
            String filePath = "D:\\" + fileName;
            String hoja = "Sheet1";

            XSSFWorkbook fWorkbook = new XSSFWorkbook();
            XSSFSheet fSheet = fWorkbook.createSheet(hoja);

            /*//Definiendo nombre de columnas
            String header[] = new String[]{"Código", "Producto", "Descripcion"};
            //Definiendo contenido de hoja
            String[][] document = new String[][]{
                {"P001", "Web cam", "Cama web marca Logitech"},
                {"P002", "Laptop", "Laptop marca Lenovo"},
                {"P003", "PS5", "PS5 marca Sony"}
            };
            for (int i = 0; i <= document.length; i++) {
                XSSFRow row = fSheet.createRow(i);
                for (int j = 0; j < header.length; j++) {
                    //Si es la primera fila
                    if (i == 0) {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(header[j]);
                    } else {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(document[i - 1][j]);
                    }
                }
            }*/
            
            //Definiendo nombre de columnas
            XSSFRow row = fSheet.createRow(1);
            XSSFCell cell;
            cell = row.createCell(1);
            cell.setCellValue("ID");
            cell = row.createCell(2);
            cell.setCellValue("Producto");
            cell = row.createCell(3);
            cell.setCellValue("Serie");
            cell = row.createCell(4);
            cell.setCellValue("Descripcion");
            cell = row.createCell(5);
            cell.setCellValue("Precio");

            Negocio negocio = new Negocio();
            //Obtenemos información de DB
            List<Products> products = negocio.findAllProducts();
            int i = 2;
            for (Products product : products) {
                row = fSheet.createRow(i);
                cell = row.createCell(1);
                cell.setCellValue(product.getId());
                cell = row.createCell(2);
                cell.setCellValue(product.getName());
                cell = row.createCell(3);
                cell.setCellValue(product.getNumberSerie());
                cell = row.createCell(4);
                cell.setCellValue(product.getProductInformation());
                cell = row.createCell(5);
                cell.setCellValue("S/ " + product.getPrice());
                i++;
            }

            File excelFile = new File(filePath);
            FileOutputStream fos = new FileOutputStream(excelFile);

            if (excelFile.exists()) {
                excelFile.delete();
                System.out.println("Archivo previo eliminado");
            }
            fWorkbook.write(fos);
            fos.flush();
            fos.close();
            System.out.println("Se creo el archvio Excel");
        } catch (IOException ex) {
            Logger.getLogger(DemoPOI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
