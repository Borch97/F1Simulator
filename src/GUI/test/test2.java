package GUI.test;

import datos.Circuito;
import datos.Gestion;
import logica.Simulacion;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1bestcsharp.blogspot.com
 */
public class test2 extends javax.swing.JFrame {


    Gestion g = new Gestion();
    Simulacion s = new Simulacion();

    /**
     * Creates new form Java_Populate_JTable_Using_ArrayList
     */
    public test2() {
        g.creacionAI();
        Circuito barcelona = new Circuito("Barcelona", "Espanya", 50, 50.0,"/pictures/test1.jpg", 82648, 85648);
        g.arrayCircuito.add(barcelona);
        s.simulacionVueltas(g.arrayCircuito,0,g.arrayCoche,g.arrayTiempoVuelta,g.arrayTiempoVueltaSoloInicial,g.posPiloto);
        initComponents();

        // use the addRowToJTable
        addRowToJTable();

    }

    // create a class User and use it to populate the arraylist
    public class informacion{
        public int pos;
        public String nombre;
        public String imagen;
        public String tiempo;
        public String Diferencia;
        public int paradasBoxes;


        public informacion(int pos, String nombre, String imagen, String tiempo, String diferencia, int paradasBoxes) {
            this.pos = pos;
            this.nombre = nombre;
            this.imagen = imagen;
            this.tiempo = tiempo;
            this.Diferencia = diferencia;
            this.paradasBoxes = paradasBoxes;
        }
    }

    // create a list of users
    public ArrayList listPilots()
    {
        ArrayList<informacion> list = new ArrayList<informacion>();

        for(int i = 0;i<g.totalPilotos;i++){
            informacion info = new informacion(i + 1,g.arrayCoche.get(i).getNom_piloto(),g.arrayCoche.get(i).getEscuderia(),g.arrayTiempoVuelta.get(i),g.arrayTiempoVuelta.get(i),g.arrayCoche.get(i).getParadasBoxes());
            list.add(info);
        }
        return list;
    }

    // added rows from arraylist to jtable
    public void addRowToJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<informacion> list = listPilots();
        Object rowData[] = new Object[6];
        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).pos;
            rowData[1] = list.get(i).nombre;
            rowData[2] = list.get(i).imagen;
            rowData[3] = list.get(i).tiempo;
            rowData[4] = list.get(i).Diferencia;
            rowData[5] = list.get(i).paradasBoxes;
            model.addRow(rowData);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Posición", "Nombre", "Coche", "Tiempo", "Diferencia", "P.Boxes"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
