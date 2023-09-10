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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    public Login() {
        setTitle("Login");
        setSize(300, 210);
        setResizable(false);
        setLocationRelativeTo(null);
        // setLayout();

        CreateLoginGUI();
    }

    private boolean CheckLogin(String login, String senha) {
        try {
            String queryLogin = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
            PreparedStatement statementLogin = database.GetConnection().prepareStatement(queryLogin);
            statementLogin.setString(1, login);
            statementLogin.setString(2, senha);

            ResultSet resultLogin = statementLogin.executeQuery();

            if (resultLogin.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    private void CreateLoginGUI() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.white);
        loginPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
                        BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(Color.BLACK),
                                "Efetuar Login")));

        // Login
        JLabel labelLogin = new JLabel("Login:");
        labelLogin.setBounds(25, 1, 100, 100);

        JTextField loginField = new JTextField();
        loginField.setToolTipText("Login");
        loginField.setBounds(75, 38, 100, 20);

        // Senha
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(33, 27, 100, 100);

        JPasswordField senhaField = new JPasswordField();
        senhaField.setToolTipText("Senha");
        senhaField.setBounds(75, 65, 100, 20);

        // Login botão
        JButton botaoLogin = new JButton("Login");
        botaoLogin.setBounds(75, 95, 100, 20);

        // Cadastrar botão
        JButton botaoNovo = new JButton("Cadastrar Novo Usuário");
        botaoNovo.setBounds(75, 120, 170, 20);

        // Login
        loginPanel.add(labelLogin);
        loginPanel.add(loginField);

        // Senha
        loginPanel.add(labelSenha);
        loginPanel.add(senhaField);

        // Botões
        loginPanel.add(botaoLogin);
        loginPanel.add(new JLabel());
        loginPanel.add(botaoNovo);

        // Eventos

        botaoLogin.addActionListener(e -> {
            String login = loginField.getText();
            String senha = new String(senhaField.getPassword());

            if (CheckLogin(login, senha)) {
                JOptionPane.showMessageDialog(null, "Acesso Autorizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");
            }
        });

        botaoNovo.addActionListener(e -> {
            dispose();
            Cadastro cadastro = new Cadastro();

            cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cadastro.setVisible(true);
        });

        add(loginPanel);
        loginPanel.setVisible(true);
    }
}
