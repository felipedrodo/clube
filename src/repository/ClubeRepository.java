package repository;

 import models.Clube; 
 import config.DbConnection;

 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

public class ClubeRepository {    

    //criar um novo Clube
    public void adicionarClube(Clube clube){
            String sql = "INSERT INTO Clubes (receita, gastos, bilheteria, serie, posicao)  VALUES (?, ?, ?)";
             

            try (Connection conn = DbConnection.getConnection();
                PreparedStatement stmt= conn.prepareStatement(sql)) {

                    stmt.setDouble(1, Clube.getReceita());
                    stmt.setDouble(2, Clube.getGastos());
                    stmt.setDouble(3, Clube.getBilheteria());
                    stmt.setString(4, Clube.getSerie());
                    stmt.setString(5, Clube.getPosicao());
                    stmt.setString(6, Clube.getPresidente());
                    stmt.setString(7, Clube.getTecnico());
                    int linhasAfetadas = stmt.executeUpdate();
                    if(linhasAfetadas > 0) {
                        System.out.println("Clube adicionado com sucesso!");
                    }

                }catch (SQLException e){
                    System.out.println("Erro ao adicionar Clube");
                    e.printStackTrace();
                }
            }

            // Obter todos os Clubes
             public List<Clube> obterTodosClubes(){
                List<Clube> Clubes  = new ArrayList<>();
                String sql=  "SELECT * FROM Clubes";

                try (Connection conn = DbConnection.getConnection();
                 Statement stmt= conn.createStatement();
                 ResultSet rs =  stmt.executeQuery(sql)){

                    while (rs.next()){
                        Clube clube  = new Clube(
                           rs. getInt("id"), 
                           rs. getDouble("receita"), 
                           rs. getDouble("gastos"), 
                           rs. getDouble("bilheteria"),
                           rs. getString("serie"), 
                           rs. getString("posição"),
                           rs. getString("presidente"),
                           rs. getString("tecnico")
                        );
                        Clubes.add(clube);
                    }

                }catch (SQLException e) {
                    System.out.println("Erro ao obter Clubes");
                    e.printStackTrace();
                }
                return Clubes;
    }

        //obter Clube por ID
        public Clube obterClubePorId(int id) {
            String sql= "SELECT * FROM Clubes  WHERE id = ?";
            Clube Clube = null;
        

        try (Connection conn = DbConnection.getConnection();
        PreparedStatement stmt= conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
                ResultSet rs =  stmt.executeQuery();

                if (rs.next()){
                    Clube  = new Clube(
                        rs. getInt("id"), 
                        rs. getDouble("receita"), 
                        rs. getDouble("gastos"), 
                        rs. getDouble("bilheteria"),
                        rs. getString("serie"), 
                        rs. getString("posição"),
                        rs. getString("presidente"), 
                        rs. getString("tecnico")
                     );
                    }

                } catch (SQLException e) {
                    System.out.println("Erro ao obter Clube por ID");
                    e.printStackTrace();
                }
                return Clube;

            }
      
            //Atualizar  um Clube

            public void AtualizarClube (Clube  Clube){
                String sql = 
                "UPDATE Clubes SET receita= ? , gastos= ? , telefone= ?, WHERE id = ?";
               
                try (Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setDouble(1, Clube.getReceita());
                    stmt.setDouble(2, Clube.getGastos());
                    stmt.setDouble(3, Clube.getBilheteria());
                    stmt.setString(4, Clube.getSerie());
                    stmt.setString(5, Clube.getPosicao());
                    stmt.setString(6, Clube.getPresidente());
                    stmt.setString(7, Clube.getTecnico());
                    stmt.setInt(8,Clube.getId());
                   
                    int linhasAfetadas = stmt.executeUpdate();
                    if(linhasAfetadas > 0 ){
                        System.out.println("Clube atualizado com sucesso!");
                    }else{
                        System.out.println("Clube não encontrado.");
                    }

                } catch (SQLException e){
                    System.out.println("Erro ao atualizar Clube");
                    e.printStackTrace();
                }
            }

            //deletar um Clube
            public void deletarClube(int id){
                String sql = "DELETE FROM Clubes WHERE id ?";

                try (Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                   
                    int linhasAfetadas = stmt.executeUpdate();
                    if(linhasAfetadas > 0 ) {
                        System.out.println("Clube deletado com sucesso!");
                    }else {
                        System.out.println("Clube não encontrado.");
                    }

                } catch (SQLException e) {
                    System.out.println("Erro ao deletar Clube");
                    e.printStackTrace();
                }
            }
        }