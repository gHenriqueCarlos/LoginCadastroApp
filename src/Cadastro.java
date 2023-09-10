import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends JFrame {
    public Cadastro() {
        setTitle("Cadastro");
        setSize(320, 230);
        setResizable(false);
        setLocationRelativeTo(null);

        CreateCadastroGUI();
    }

    private boolean SalvarCadastro(String nome, String login, String senha, String email) {
        try {
            String queryCadastro = "insert into usuario(nome, login, senha, email) values (?,?,?,?)";
            PreparedStatement statementCadastro = database.GetConnection().prepareStatement(queryCadastro);
            statementCadastro.setString(1, nome);
            statementCadastro.setString(2, login);
            statementCadastro.setString(3, senha);
            statementCadastro.setString(4, email);
            int resultado = statementCadastro.executeUpdate();

            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    private void CreateCadastroGUI() {
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(null);
        cadastroPanel.setBackground(Color.white);
        cadastroPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
                        BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(Color.BLACK),
                                "Cadastrar Novo Usuário")));

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(25, 15 + 10, 100, 20);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(75, 15 + 10, 180, 20);

        JLabel labelLogin = new JLabel("Login:");
        labelLogin.setBounds(25, 45 + 10, 100, 20);

        JTextField loginField = new JTextField();
        loginField.setBounds(75, 45 + 10, 180, 20);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(25, 75 + 10, 100, 20);

        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(75, 75 + 10, 180, 20);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(25, 105 + 10, 100, 20);

        JTextField emailField = new JTextField();
        emailField.setBounds(75, 105 + 10, 180, 20);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(115, 145 + 10, 100, 20);

        cadastroPanel.add(labelNome);
        cadastroPanel.add(nomeField);
        cadastroPanel.add(labelLogin);
        cadastroPanel.add(loginField);
        cadastroPanel.add(labelSenha);
        cadastroPanel.add(senhaField);
        cadastroPanel.add(labelEmail);
        cadastroPanel.add(emailField);
        cadastroPanel.add(botaoSalvar);

        botaoSalvar.addActionListener(e -> {
            String nome = nomeField.getText();
            String login = loginField.getText();
            String senha = new String(senhaField.getPassword());
            String email = emailField.getText();

            if (SalvarCadastro(nome, login, senha, email)) {
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                dispose();

                Login loginGUI = new Login();

                loginGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginGUI.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar.");
            }
        });

        add(cadastroPanel);
        cadastroPanel.setVisible(true);
    }
}
