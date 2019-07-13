package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import Dao.UserDao;
import Dao.UserMongoDb;
import Dao.UserRedisDao;

public class UserService {
	
	@Autowired
	UserDao dao_user;
	@Autowired
	UserRedisDao dao_user_redis;
	@Autowired
	UserMongoDb dao_user_mongo;
	
	public String insertMysql() {
		
		return dao_user.Insert();
	}
	
   public String getRedisData() {
		
		//return dao_user_redis.redisGet();
	   System.out.println("Hello");
	   return "Hello";
	}
   public String insertIntoMongo() {
		
		String str= dao_user_mongo.insert();
		
		return "Hi";
	}
   public String insertWthWhereIntoMongo() {
	   /////
	   BasicDBObject bdb_query = new BasicDBObject();
	   bdb_query.put("_id", 0);
	   bdb_query.append("SUBJECT",1);
	   Document srch_query = new Document();
	   
	   //srch_query.put("A", "a");
	   //BasicQuery query=new BasicQuery(srch_query,bdb_query);
	   /*BasicQuery query=new BasicQuery(srch_query,bdb_query);
	   
	    BasicDBObject fields = new BasicDBObject();
	    fields.put("employeeId");
	  
	    //DBCursor cursor = collection.find(whereQuery, fields);
	    while (cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }*/
	   
	   /////
		
		String str= dao_user_mongo.insertWithWhere();
		
		return "Hi";
	}
   public String deleteFromMongo() {
		
	   dao_user_mongo.delete();
		
		return "Hi";
	}
   public String setGetExcel() {
	   
	   try {
	   File myFile = new File("E:\\codes2\\ExcelFile.xlsx");
       FileInputStream fis = new FileInputStream(myFile);

       // Finds the workbook instance for XLSX file
       XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
      
       // Return first sheet from the XLSX workbook
       XSSFSheet mySheet = myWorkBook.getSheetAt(0);
      
       // Get iterator to all the rows in current sheet
       Iterator<Row> rowIterator = mySheet.iterator();
      
       // Traversing over each row of XLSX file
            int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				i++;
				if (i != 1) {
				int j=0;	
				while (cellIterator.hasNext()) {
                        j++;					
						Cell cell = cellIterator.next();

						switch (cell.getCellType()) {
						
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							if (j == 2) {
								cell.setCellValue(cell.getStringCellValue() + " Modified");
							}
							break;
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							cell.setCellValue(cell.getNumericCellValue() +1);
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.print(cell.getBooleanCellValue() + "\t");
							break;
						default:

						}
					}
				}
				System.out.println("");
			}
			// open an OutputStream to save written data into XLSX file
            FileOutputStream os = new FileOutputStream(myFile);
            myWorkBook.write(os);
            System.out.println("Writing on XLSX file Finished ...");
		} catch (Exception e) {
			return "Exception";
		}

		return "Hi";
	}
	

}
