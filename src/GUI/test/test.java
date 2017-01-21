package GUI.test;

import GUI.Ventana;
import datos.Circuito;
import datos.Coche;
import datos.Gestion;
import logica.Simulacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test {

    private static ArrayList<Integer> rowpos = new ArrayList();
    private static ArrayList<String> rowNombre = new ArrayList();
    private static ArrayList<String> rowCoche = new ArrayList();
    private static ArrayList<String> rowTiempo = new ArrayList();
    private static ArrayList<String> rowDiferencia = new ArrayList();
    private static ArrayList<Integer> rowPBox = new ArrayList();
    private static ArrayList<String> titel = new ArrayList();
    private static ArrayList<ArrayList<testInformacion>> table = new ArrayList();
    static Gestion g = new Gestion();
    static Simulacion s = new Simulacion();
    static Ventana v = new Ventana();
    JTable EndTable;

    public static void main(String[] args) {

        titel.add("Posición");
        titel.add("Nombre");
        titel.add("Coche");
        titel.add("Tiempo");
        titel.add("Diferencia");
        titel.add("P.Boxes");

        g.creacionAI();
        Circuito barcelona = new Circuito("Barcelona", "Espanya", 50, 50.0,"/pictures/test1.jpg", 82648, 85648, 0);
        g.arrayCircuito.add(barcelona);
        s.simulacionVueltas(g.arrayCircuito,0,g.arrayCoche,g.arrayTiempoVuelta,g.arrayTiempoVueltaSoloInicial,g.posPiloto, true);
        addRows(g.arrayCoche,g.arrayTiempoVuelta);
        /*addRows(g.arrayCoche,g.arrayTiempoVuelta);
        addRows(g.arrayCoche,g.arrayTiempoVuelta);
        addRows(g.arrayCoche,g.arrayTiempoVuelta);
        addRows(g.arrayCoche,g.arrayTiempoVuelta);
        addRows(g.arrayCoche,g.arrayTiempoVuelta);*/


        /*table.add(rowpos);
        table.add(rowNombre);
        table.add(rowCoche);
        table.add(rowTiempo);
        table.add(rowDiferencia);
        table.add(rowPBox);*/

        Object[] tempTitel = titel.toArray();
        testInformacion[][] tempTable = new testInformacion[table.size()][];
        int i = 0;
        for (List<testInformacion> next : table) {
            tempTable[i++] = next.toArray(new testInformacion[next.size()]);
        }

        JTable EndTable = new JTable(tempTable,tempTitel);
        DefaultTableModel model = (DefaultTableModel) EndTable.getModel();
        Object rowData[] = new Object[6];
        for(int j = 0; i < table.size(); j++)
        {
            rowData[0] = table.get(j).get(j).getPos();
            rowData[1] = table.get(j).get(j).getNombre();
            rowData[2] = table.get(j).get(j).getImagen();
            rowData[3] = table.get(j).get(j).getTiempo();
            rowData[4] = table.get(j).get(j).getDiferencia();
            rowData[5] = table.get(j).get(j).getParadasBoxes();
            model.addRow(rowData);
        }

        JFrame frame = new JFrame("Demo");
        frame.getContentPane().add(new JScrollPane(EndTable));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void addRows(ArrayList<Coche> coche, ArrayList<String> tiempo) {

        for(int i = 0;i<coche.size();i++){
           // testInformacion ti = new testInformacion(Integer.toString(i + 1),coche.get(i).getNombre(),coche.get(i).getEscuderia(),tiempo.get(i),tiempo.get(i),Integer.toString(coche.get(i).getParadasBoxes()));
            /*rowpos.add(ti.getPos());
            rowNombre.add(ti.getNombre());
            rowCoche.add(ti.getImagen());
            rowTiempo.add(ti.getTiempo());
            rowDiferencia.add(ti.getDiferencia());
            rowPBox.add(ti.getParadasBoxes());
            rowpos.add("rowpos");
            rowNombre.add("rownombre");
            rowCoche.add("rowcoche");
            rowTiempo.add("rowtiempo");
            rowDiferencia.add("rowdiferencia");
            rowPBox.add("rowbox");*/



        }
        /*rowA.add(coche.get(rowa).getNombre());
        rowB.add(rowb);
        rowC.add(rowc);
        rowTest.add(rowtest);*/

    }

    static class arrayInformacion{
        ArrayList<Integer> pos;
        ArrayList<String> nombre;
        ArrayList<String> coche;
        ArrayList<String> tiempo;
        ArrayList<String> diferencia;
        ArrayList<Integer> pbox;


        public arrayInformacion(ArrayList<Integer> pos, ArrayList<String> nombre, ArrayList<String> coche, ArrayList<String> tiempo, ArrayList<String> diferencia, ArrayList<Integer> pbox) {
            this.pos = pos;
            this.nombre = nombre;
            this.coche = coche;
            this.tiempo = tiempo;
            this.diferencia = diferencia;
            this.pbox = pbox;
        }
    }

}
