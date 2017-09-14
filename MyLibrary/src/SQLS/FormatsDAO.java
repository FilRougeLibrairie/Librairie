
package SQLS;

import ClassObjet.Formats;
import Names.SQLNames.FormatsNames;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class FormatsDAO extends DAO{
    private final String ID = FormatsNames.ID;
    private final String FORNAME = FormatsNames.NAME;
   
    
    private String COLUMNS =  FORNAME ;
    
    
    public FormatsDAO() {
        super();
    }
    
   
    
       @Override
    public void create(Object obj) {
        Formats form = (Formats) obj;
        String query = "IF NOT EXISTS (SELECT * FROM FORMATS WHERE " + ID + " = '" + form.getForId() + "')"
                + "INSERT INTO FORMATS (" + COLUMNS + ")"
                + "VALUES (?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, form.getForName());
           
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING CONTACT : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    
    
    
    
    
    @Override
    public void delete(Object obj) {
       
    
        int formId = ((Formats) obj).getForId();
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM Formats WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + formId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();
        }
 
    
    }

    
    
    @Override
    public void update(Object obj) {
 
      
        Formats form = (Formats)obj;
        StringBuilder query = new StringBuilder("UPDATE Formats SET ");
        query.append(FORNAME).append(" = ? ");
        

        query.append("WHERE " + ID + " = '")
                .append(form.getForId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, form.getForName());
            

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING CONTACT : " + ex.getMessage());
            ex.printStackTrace();

        }
    }
    
 

    @Override
    public Object find(int id) {   
        Formats form = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM FORMATS WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    form = new Formats();
                    form.setForId(rs.getInt(ID));
                    form.setForName(rs.getString(FORNAME));
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();

        }
        return form;
    }
        
   
    
    
    ////////////////////////

    @Override
    public Vector findAll() {
        Vector<Formats> formatsList = new Vector<Formats>();
        Formats format = null;

        String query = "SELECT * FROM FORMATS";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    format = new Formats();
                    format.setForId(rs.getInt(ID));
                    format.setForName(rs.getString(FORNAME));
                    
                    formatsList.add(format);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();

        }
        return formatsList;
    }

  
    
    
    public Vector<Formats> findByColumn(String column, String term) {

        Vector<Formats> formatsList = new Vector<Formats>();
        Formats format = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM Formats WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    format = new Formats();
                    format.setForId(rs.getInt(ID));
                    format.setForName(rs.getString(FORNAME));
                    formatsList.add(format);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();

        }
        return formatsList;
    }

    @Override
    public Object find(String forName) {
        
        
        
          Formats form = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM FORMATS WHERE ")
                .append(FORNAME)
                .append(" = ")
                .append("'" + forName + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    form = new Formats();
                    form.setForName(rs.getString(FORNAME));

                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            ex.printStackTrace();

        }
        return form;
        
        
        
        
        
        
        
        
    }
}
