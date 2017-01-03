package datos;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class informacionTableModel extends AbstractTableModel {

    Gestion g = new Gestion();

    private ArrayList<informacionTabla> informacion;

    public informacionTableModel(ArrayList<informacionTabla> informacion) {
        this.informacion = informacion;
    }


    @Override
    public int getRowCount() {
        return g.informacionTabla.size();
    }

    @Override
    public int getColumnCount() {
        return g.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        informacionTabla contact = g.informacionTabla.get(rowIndex);

        switch (columnIndex) {
            case 0: return contact.getNombre();
            case 1: return contact.getImagen();
            case 2: return contact.getTiempo();
            case 3: return contact.getDiferencia();
            case 4: return contact.getParadasBoxes();
            default : return -1;
        }
    }
}
