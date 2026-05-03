import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CalcGridPane extends GridPane {
    private Label lblAmount;
    private Label lblPeriod;
    private Label lblRate;
    private Label lblPayment;
    private Label lblTotalPaid;

    private TextField txtAmount;
    private TextField txtPeriod;
    private TextField txtRate;
    private TextField txtPayment;
    private TextField txtTotalPayment;

    public CalcGridPane() {
        lblAmount = new Label("Loan Amount ($):");
        lblPeriod = new Label("Loan Period (months):");
        lblRate = new Label("Interest Rate (%):");
        lblPayment = new Label("Monthly Payment Amount:");
        lblTotalPaid = new Label("Total Amount Paid");

        txtAmount = new TextField();
        txtPeriod = new TextField();
        txtRate = new TextField();
        txtPayment = new TextField();
        txtTotalPayment = new TextField();
        txtPayment.setEditable(false);
        txtTotalPayment.setEditable(false);

        this.add(lblAmount, 0, 0);
        this.add(txtAmount, 1, 0);
        this.add(lblPeriod, 0, 1);
        this.add(txtPeriod, 1, 1);
        this.add(lblRate, 0, 2);
        this.add(txtRate, 1, 2);
        this.add(lblPayment, 0, 3);
        this.add(txtPayment, 1, 3);
        this.add(lblTotalPaid, 0, 4);
        this.add(txtTotalPayment,1, 4);

        this.setHgap(10);
        this.setVgap(10);
        this.setPadding( new Insets(10, 10, 10,10));
    }

    public void calculatePayment() {
        double amount = Double.parseDouble(txtAmount.getText());
        double rate = Double.parseDouble(txtRate.getText())/100/12;
        int period = Integer.parseInt(txtPeriod.getText());

        //M = P * [r(1 + r)^n] / [(1 + r)^n - 1]
        double num = amount * (rate * Math.pow((1 + rate),period)) ;
        double den = (Math.pow((1 + rate),period) - 1);
        double payment = num/den;
        //txtPayment.setText(payment+"");
        txtPayment.setText(String.format("%.2f",payment));
    }

    public void clearFields(){
        txtPayment.setText("");
        txtAmount.setText("");
        txtPeriod.setText("");
        txtRate.setText("");
    }


}
