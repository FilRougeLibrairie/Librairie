package SQLS;

import ClassObjet.AccessProfile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class AccessProfile_SQL {
    
    private final String TABLE = "AccessProfile";
    private final String PROFILE_CODE = "accProfileCode";
    private final String PROFILE_NAME = "accProfileName";
    
     ConnexionBase connexion;
     AccessProfile accessProfile;

    public AccessProfile_SQL() {
        connexion = new ConnexionBase();
    }
    
     public Vector findAllInTable() throws SQLException, ParseException {
         Vector <AccessProfile> vectAccess = new Vector<AccessProfile>();
         
         try (Statement stmt = this.connexion.getInstance().createStatement();) {

            String query = "SELECT * FROM " + TABLE;
            
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                accessProfile = new AccessProfile();
                accessProfile.setAccProfileCode(rs.getInt(PROFILE_CODE));
                accessProfile.setAccProfileName(rs.getString(PROFILE_NAME));
                
                vectAccess.add(accessProfile);
            }
        } catch (SQLException ex) {
            System.err.println("Statement Error in method loadContacts, class Employee_SQL : " + ex.getErrorCode() + " / " + ex.getMessage());
        }
        return vectAccess;
     }
     
     public Vector findNameInTable(AccessProfile accessProfile) throws SQLException, ParseException {
         Vector <AccessProfile> vectName = new Vector<AccessProfile>();
         
         try (Statement stmt = this.connexion.getInstance().createStatement();) {

            String query = "SELECT " + PROFILE_NAME + " FROM " + TABLE +" WHERE " + PROFILE_CODE + " = " + accessProfile.getAccProfileCode();
            
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                accessProfile.setAccProfileName(rs.getString(PROFILE_NAME));
                vectName.add(accessProfile);
            }
        } catch (SQLException ex) {
            System.err.println("Statement Error in method loadContacts, class Employee_SQL : " + ex.getErrorCode() + " / " + ex.getMessage());
        }
        return vectName;
     }
}
