
package SQLS;

import ClassObjet.Forma;
import Names.SQLNames.FormatsNames;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class FormatsDAO extends DAO{
    private final String TABLE = "Formats";
    private final String ID = FormatsNames.ID;
    private final String FORNAME = FormatsNames.NAME;
    private final String STATUS = FormatsNames.STATUS;
    
    private String COLUMNS_CREATE = FORNAME + ", " + STATUS;
    
   
    public FormatsDAO() {
        super();
    }
    
   
    
       @Override
    public void create(Object obj) {
        Forma form = (Forma) obj;
        String query = "IF NOT EXISTS (SELECT * FROM "+TABLE+" WHERE " + FORNAME + " = '" + form.getForName()+ "')"
                + "INSERT INTO "+TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, form.getForName());
            pstmt.setInt(2, form.getForStatus());
           
            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING CONTACT : " + ex.getErrorCode() + " / " + ex.getMessage());
            
        }
    }

    
    public Boolean answer(Forma obj){
        Boolean answer=true;
        Forma format = (Forma) obj;
        String query = "SELECT * FROM Formats WHERE forName= '"+format.getForName()+"'";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {
                answer=true;
            } else {
                answer=false;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            

        }
        return answer;
        
        
    }   
    
    
    
    @Override
    public void delete(Object obj) {
       
        int formId = ((Forma) obj).getForId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM Formats WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + formId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            
        }
 
    
    }

    
    
    @Override
    public void update(Object obj) {
 
      
        Forma form = (Forma)obj;
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
            

        }
    }
    
 

    @Override
    public Forma find(int id) {   
        Forma form = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM FORMATS WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    form = new Forma();
                    form.setForId(rs.getInt(FormatsNames.ID));
                    form.setForName(rs.getString(FormatsNames.NAME));
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return form;
    }
        
   
    

    @Override
    public Vector<Forma> findAll() {
        Vector<Forma> formatsList = new Vector<Forma>();
        Forma format = null;
        String query = "SELECT * FROM FORMATS";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    format = new Forma();
                    format.setForId(rs.getInt(ID));
                    format.setForName(rs.getString(FORNAME));
                    format.setForStatus(rs.getInt("forStatus"));
                    formatsList.add(format);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return formatsList;
    }

  
    
    
    public Vector<Forma> findByColumn(String column, String term) {

        Vector<Forma> formatsList = new Vector<Forma>();
        Forma format = null;

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
                    format = new Forma();
                    format.setForId(rs.getInt(ID));
                    format.setForName(rs.getString(FORNAME));
                    format.setForStatus(rs.getInt(STATUS));
                    formatsList.add(format);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return formatsList;
    }

    @Override
    public Object find(String forName) {
        
        
        
        Forma form = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM FORMATS WHERE ")
                .append(FORNAME)
                .append(" = ")
                .append("'" + forName + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    form = new Forma();
                    form.setForId(Integer.valueOf(ID));
                    form.setForName(rs.getString(FORNAME));
                    form.setForStatus(rs.getInt(STATUS));
                    
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Customer : " + ex.getMessage());
            

        }
        return form;
        
        
        
        
        
        
        
        
    }
}
