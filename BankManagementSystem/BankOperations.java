import java.sql.*;

public class BankOperations {
    public void createAccount(String name, double balance) {
        try (Connection con = DBconnection.getConnection()) {
            String query = "INSERT INTO accounts(name, balance) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setDouble(2, balance);
            ps.executeUpdate();
            System.out.println("Account created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewAccounts() {
        try (Connection con = DBconnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Balance: " + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deposit(int id, double amount){
        try(Connection con = DBconnection.getConnection()){
              String query = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
              PreparedStatement ps = con.prepareStatement(query);
              ps.setDouble(1, amount);
              ps.setInt(2, id);
              int rows = ps.executeUpdate();
              if(rows>0){
                System.out.println("Deposit completed");
              }
              else{
                System.out.println("Account not found");
              }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void withdraw(int id, double amount){
        try(Connection con = DBconnection.getConnection()){
            String viewQuery = "SELECT balance FROM accounts WHERE id = ?";
            PreparedStatement Viewps = con.prepareStatement(viewQuery);
             Viewps.setInt(1, id);
             ResultSet rs = Viewps.executeQuery();
        
        if(rs.next()){
            double currentbalance = rs.getDouble("balance");
            if(currentbalance>=amount){
                String updateQuery = "UPDATE accounts SET balance = balance - ? WHERE id  = ?";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setDouble(1, amount);
                ps.setInt(2, id);
                ps.executeUpdate();
                System.out.println("Withdraw completed ");
            }
            else{
                System.out.println("Insufficient balance");
            }
           
        }
         else{
                System.out.println("Account not found or Invalid Input");
            }
    }
    catch(SQLException e){
            e.printStackTrace();
        }
    }
        public void deleteAccount(int id){
            try(Connection con = DBconnection.getConnection()){
            String Query = "DELETE FROM accounts WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("Account deleted");
            }
            else{
                System.out.println("Account not found or Invalid input");
            }
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }
}
