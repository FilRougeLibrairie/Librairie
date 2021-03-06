/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.Editor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author cdi312
 */
public class EditorDAO extends DAO {

    private final String TABLE = "Editor";

    public final String ID = EditorNames.ID;
    public final String NAME = EditorNames.NAME;
    public final String PRESENTATION = EditorNames.PRESENTATION;
    public final String STATUS = EditorNames.STATUS;

    private String COLUMNS_CREATE = NAME + ", " + PRESENTATION + ", " + STATUS;

    public EditorDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        Editor edi = (Editor) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + edi.getEdiId() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setString(1, edi.getEdiName());
            pstmt.setString(2, edi.getEdiPresentation());
            pstmt.setInt(3, edi.getEdiStatusCode());

            int result = pstmt.executeUpdate();
            System.out.println("Objet crée");
        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void delete(Object obj) {
        int ediId = ((Editor) obj).getEdiId();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + ediId + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object obj) {
        Editor edi = (Editor) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(NAME).append(" =?, ");
        query.append(PRESENTATION).append(" =?, ");
        query.append(STATUS).append(" =? ");

        query.append("WHERE " + ID + " = '")
                .append(edi.getEdiId())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {
            pstmt.setString(1, edi.getEdiName());
            pstmt.setString(2, edi.getEdiPresentation());
            pstmt.setInt(3, edi.getEdiStatusCode());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Vector findAll() {
        Vector<Editor> editorList = new Vector<Editor>();
        Editor editor = null;

        String query = "SELECT * FROM " + TABLE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    editor = new Editor();
                    editor.setEdiId(rs.getInt(ID));
                    editor.setEdiName(rs.getString(NAME));
                    editor.setEdiPresentation(rs.getString(PRESENTATION));
                    editor.setEdiStatusCode(rs.getInt(STATUS));
                    editorList.add(editor);
                }

            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
        return editorList;
    }

    
    public Object findById(int id) {
        Editor editor = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            
        if (rs.isBeforeFirst()) {
            
                while (rs.next()) {
                    editor = new Editor();
                    editor.setEdiId(rs.getInt(ID));
                    editor.setEdiName(rs.getString(NAME));
                    editor.setEdiPresentation(rs.getString(PRESENTATION));
                    editor.setEdiStatusCode(rs.getInt(STATUS));
                }

        }else {
               
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println(query);
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
        return editor;
    }

   
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public Vector<Editor> findByCriteria(String column, String term) {

        Vector<Editor> editorList = new Vector<Editor>();
        Editor editor = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" LIKE ")
                .append("'" + term + "%'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    editor = new Editor();
                    editor.setEdiId(rs.getInt(ID));
                    editor.setEdiName(rs.getString(NAME));
                    editor.setEdiPresentation(rs.getString(PRESENTATION));
                    editor.setEdiStatusCode(rs.getInt(STATUS));
                    editorList.add(editor);
                }
                System.out.println(query);
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println(query);
            System.out.println("ERROR Retrieving Object criteria : " + ex.getMessage());
            ex.printStackTrace();
        }
        return editorList;
    }

    public Vector findByStatut(int statut) {
        Vector<Editor> editorList = new Vector<Editor>();
        Editor editor = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(STATUS)
                .append(" = ")
                .append("'" + statut + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    editor = new Editor();
                    editor.setEdiId(rs.getInt(ID));
                    editor.setEdiName(rs.getString(NAME));
                    editor.setEdiPresentation(rs.getString(PRESENTATION));
                    editor.setEdiStatusCode(rs.getInt(STATUS));
                    editorList.add(editor);
                }

            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {

            System.out.println("ERROR Retrieving Object statut : " + ex.getMessage());
            ex.printStackTrace();
        }
        return editorList;
    }

    @Override
    public Editor find(int id) {
       Editor editor = null;
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(ID)
                .append(" = ")
                .append(id);

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    editor = new Editor();
                    editor.setEdiId(rs.getInt(ID));
                    editor.setEdiName(rs.getString(NAME));
                    editor.setEdiPresentation(rs.getString(PRESENTATION));
                    editor.setEdiStatusCode(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
            ex.printStackTrace();
        }
        return editor;
    }

    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findByColumn(String column, String term) {
      
              Vector<Editor> editorList = new Vector<Editor>();
        Editor editor = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "' ORDER BY autId");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    editor = new Editor();
                    editor.setEdiId(rs.getInt(ID));
                    editor.setEdiName(rs.getString(NAME));
                    editor.setEdiPresentation(rs.getString(PRESENTATION));
                    editor.setEdiStatusCode(rs.getInt(STATUS));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return editorList;
        
        
    }
}
