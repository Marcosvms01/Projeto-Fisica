package com.mycompany.projetofisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProjetoFisica extends JFrame {

    private final JTextField tParadoInicioField;
    private final JTextField tParadoFimField;
    private final JTextField velocidadeField;
    private final JTextField tInicioField;
    private final JTextField tFimField;
    private final JTextArea resultadoArea;

    public ProjetoFisica() {
        setTitle("Calculadora de Movimento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Tempo inicial parado (min):"));
        tParadoInicioField = new JTextField();
        inputPanel.add(tParadoInicioField);

        inputPanel.add(new JLabel("Tempo final parado (min):"));
        tParadoFimField = new JTextField();
        inputPanel.add(tParadoFimField);

        inputPanel.add(new JLabel("Velocidade durante o movimento (m/s):"));
        velocidadeField = new JTextField();
        inputPanel.add(velocidadeField);

        inputPanel.add(new JLabel("Tempo inicial do intervalo (min):"));
        tInicioField = new JTextField();
        inputPanel.add(tInicioField);

        inputPanel.add(new JLabel("Tempo final do intervalo (min):"));
        tFimField = new JTextField();
        inputPanel.add(tFimField);

        JButton calcularButton = new JButton("Calcular");
        inputPanel.add(calcularButton);
        inputPanel.add(new JLabel());

        add(inputPanel, BorderLayout.NORTH);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(scrollPane, BorderLayout.CENTER);

        calcularButton.addActionListener((ActionEvent e) -> {
            calcularResultados();
        });
    }

    private double posicao(double t, double tParadoFim, double velocidade) {
        if (t <= tParadoFim) {
            return 0;
        } else {
            return velocidade * (t - tParadoFim);
        }
    }

    private void calcularResultados() {
        try {
            double tParadoInicio = Double.parseDouble(tParadoInicioField.getText()) * 60;
            double tParadoFim = Double.parseDouble(tParadoFimField.getText()) * 60;
            double velocidade = Double.parseDouble(velocidadeField.getText());
            double tInicio = Double.parseDouble(tInicioField.getText()) * 60;
            double tFim = Double.parseDouble(tFimField.getText()) * 60;

            if (tFim <= tInicio) {
                JOptionPane.showMessageDialog(this, "Tempo final do intervalo deve ser maior que o inicial.", "Erro de tempo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tParadoFim < tParadoInicio) {
                JOptionPane.showMessageDialog(this, "Tempo final parado deve ser maior que o inicial parado.", "Erro de tempo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double xInicio = posicao(tInicio, tParadoFim, velocidade);
            double xFim = posicao(tFim, tParadoFim, velocidade);
            double deltaX = xFim - xInicio;
            double deltaT = tFim - tInicio;

            if (deltaT == 0) {
                resultadoArea.setText("Intervalo de tempo inválido (0 segundos).");
                return;
            }

            double velocidadeMedia = deltaX / deltaT;
            double vInicio = (tInicio <= tParadoFim) ? 0 : velocidade;
            double vFim = (tFim <= tParadoFim) ? 0 : velocidade;
            double aceleracaoMedia = (vFim - vInicio) / deltaT;

            resultadoArea.setText(String.format(
                "Velocidade média: %.4f m/s%nAceleração média: %.4f m/s²",
                velocidadeMedia, aceleracaoMedia
            ));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjetoFisica gui = new ProjetoFisica();
            gui.setVisible(true);
        });
    }
}
