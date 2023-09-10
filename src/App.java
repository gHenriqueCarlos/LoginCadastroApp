import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 
         * ATENÇÃO AO DADOS DO DATABASE:
         * Porta: 3306
         * Usuario: root
         * Senha: root
         * 
         */
        // System.out.println("Conexão: " + database.GetConnection());

        if (database.GetConnection() == null)
            System.out.println("Conexão inválida");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();

                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setVisible(true);

                // Cadastro cadastro = new Cadastro();

                // cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // cadastro.setVisible(true);
            }
        });
    }
}
