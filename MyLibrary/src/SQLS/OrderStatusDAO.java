/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLS;

import ClassObjet.OrderStatus;
import ClassObjet.Purchase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ggarvanese
 */
public class OrderStatusDAO extends DAO {

    private final String TABLE = "OrderStatus";

    private final String CODE = OrderStatusNames.CODE;
    private final String NAME = OrderStatusNames.NAME;

    private String COLUMNS_CREATE = CODE + ", " + NAME;

    public OrderStatusDAO() {
        super();
    }

    @Override
    public void create(Object obj) {
        OrderStatus ord = (OrderStatus) obj;
        String query = "IF NOT EXISTS (SELECT * FROM " + TABLE + " WHERE " + CODE + " = '" + ord.getStaCode() + "')"
                + "INSERT INTO " + TABLE + " (" + COLUMNS_CREATE + ")"
                + "VALUES (?, ?)";

        try (PreparedStatement pstmt = this.connect.prepareStatement(query);) {

            pstmt.setInt(1, ord.getStaCode());
            pstmt.setString(2, ord.getStaName());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("ERROR SAVING Object : " + ex.getErrorCode() + " / " + ex.getMessage());

        }
    }

    @Override
    public void delete(Object obj) {
        int ordCode = ((OrderStatus) obj).getStaCode();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append("'" + ordCode + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
    }

    @Override
    public void update(Object obj) {
        OrderStatus ord = (OrderStatus) obj;
        StringBuilder query = new StringBuilder("UPDATE " + TABLE + " SET ");
        query.append(NAME).append(" = ? ");

        query.append("WHERE " + CODE + " = '")
                .append(ord.getStaCode())
                .append("'");

        try (PreparedStatement pstmt = connect.prepareStatement(query.toString());) {

            pstmt.setString(1, ord.getStaName());

            int result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR UPDATING Object : " + ex.getMessage());

        }
    }

    @Override
    public Vector findAll() {
        Vector<OrderStatus> ordList = new Vector<OrderStatus>();
        OrderStatus ord = null;

        String query = "SELECT * FROM " + TABLE + " ORDER BY " + StatusDisplayNames.CODE;

        try (PreparedStatement pstmt = this.connect.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    ord = new OrderStatus();

                    ord.setStaCode(rs.getInt(CODE));
                    ord.setStaName(rs.getString(NAME));
                    ordList.add(ord);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return ordList;
    }

    @Override
    public OrderStatus find(int id) {
        OrderStatus ord = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(CODE)
                .append(" = ")
                .append("'" + id + "'");

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    ord = new OrderStatus();

                    ord.setStaCode(rs.getInt(CODE));
                    ord.setStaName(rs.getString(NAME));

                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return ord;
    }

    @Override
    public Object find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector findByColumn(String column, String term) {
        Vector<OrderStatus> ordList = new Vector<OrderStatus>();
        OrderStatus ord = null;

        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM " + TABLE + " WHERE ")
                .append(column)
                .append(" = ")
                .append("'" + term + "'");

        System.out.println();

        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    ord = new OrderStatus();

                    ord.setStaCode(rs.getInt(CODE));
                    ord.setStaName(rs.getString(NAME));
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());

        }
        return ordList;
    }

    public Vector<OrderStatus> findOrderStatusByPurchaseId(int purchaseId) {
        Vector<OrderStatus> orderStatusList = new Vector<OrderStatus>();
        OrderStatus orderStatus;
        Purchase pur;
        StringBuffer query = new StringBuffer();
        query.append("DECLARE @purchaseId int ")
                .append("SET @purchaseId = ? ")
                .append("SELECT * ")
                .append("FROM OrderStatus os ")
                .append("JOIN Determinate det ")
                .append("ON os.staCode = det.staCode ")
                .append("JOIN Purchase pur ")
                .append("ON det.purId = pur.purId ")
                .append("WHERE pur.purId = @purchaseId ")
                .append("ORDER BY det.detTime DESC");
        
        try (PreparedStatement pstmt = this.connect.prepareStatement(query.toString())) {

            pstmt.setInt(1, purchaseId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {

                while (rs.next()) {
                    orderStatus = new OrderStatus();
                    pur = new Purchase();
                    orderStatus.setStaCode(rs.getInt(CODE));
                    orderStatus.setStaName(rs.getString(NAME));
                    pur.setPurId((rs.getInt("purId")));
                    orderStatus.setPurchase(pur);
                    orderStatus.setStatusDate(rs.getString("detTime"));
                    orderStatusList.add(orderStatus);
                }
            } else {
                throw new SQLException("ResultSet was empty");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR Retrieving Object : " + ex.getMessage());
        }
        return orderStatusList;
    }

}
