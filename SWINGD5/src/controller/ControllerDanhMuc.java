/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DanhMuc;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import sun.management.GcInfoCompositeData;

/**
 *
 * @author vuongluis
 */
public class ControllerDanhMuc extends AbstractTableModel {
    private ArrayList<DanhMuc> alDanhMuc = new ArrayList<DanhMuc>();
    private String[] arCol = {"<html><b>Id danh mục</b></html>","<html><b>Tên danh mục</b></html>","<html><b>Trạng thái</b></html>"};
    private JTable table;
    public ControllerDanhMuc(JTable tbMain) {
        alDanhMuc.add(new DanhMuc(1,"Tin thể thao",true));
        alDanhMuc.add(new DanhMuc(2,"Tin giải trí",false));
        alDanhMuc.add(new DanhMuc(13,"Tin trong nước",true));
        alDanhMuc.add(new DanhMuc(4,"Tin thế giới",false));
        alDanhMuc.add(new DanhMuc(5,"Tin rao vặt",true));
        alDanhMuc.add(new DanhMuc(1,"Tin thể thao",true));
        alDanhMuc.add(new DanhMuc(2,"Tin giải trí",false));
        alDanhMuc.add(new DanhMuc(13,"Tin trong nước",true));
        alDanhMuc.add(new DanhMuc(4,"Tin thế giới",false));
        alDanhMuc.add(new DanhMuc(5,"Tin rao vặt",true));
        alDanhMuc.add(new DanhMuc(1,"Tin thể thao",true));
        alDanhMuc.add(new DanhMuc(2,"Tin giải trí",false));
        alDanhMuc.add(new DanhMuc(13,"Tin trong nước",true));
        alDanhMuc.add(new DanhMuc(4,"Tin thế giới",false));
        alDanhMuc.add(new DanhMuc(5,"Tin rao vặt",true));
        alDanhMuc.add(new DanhMuc(1,"Tin thể thao",true));
        alDanhMuc.add(new DanhMuc(2,"Tin giải trí",false));
        alDanhMuc.add(new DanhMuc(13,"Tin trong nước",true));
        alDanhMuc.add(new DanhMuc(4,"Tin thế giới",false));
        alDanhMuc.add(new DanhMuc(5,"Tin rao vặt",true));
        alDanhMuc.add(new DanhMuc(1,"Tin thể thao",true));
        alDanhMuc.add(new DanhMuc(2,"Tin giải trí",false));
        alDanhMuc.add(new DanhMuc(13,"Tin trong nước",true));
        alDanhMuc.add(new DanhMuc(4,"Tin thế giới",false));
        alDanhMuc.add(new DanhMuc(5,"Tin rao vặt",true));
        this.table = tbMain;
    }

    @Override
    public int getRowCount() {
        return alDanhMuc.size();
    }

    @Override
    public int getColumnCount() {
        return arCol.length;
    }

    @Override
    public String getColumnName(int column) {
        return arCol[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==0){
            return Integer.class;
        }
        if(columnIndex==2){
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex); 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DanhMuc objDM = alDanhMuc.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result=objDM.getId();
                break;
            case 1:
                result=objDM.getName();
                break;
            case 2:
                result=objDM.isActive();
                break;
        }
        return result;
    }

    public void loadTable() {
        /**
         * Insert data into table name
         */
        table.setModel(this);
        /**
         * Specify transparent 
         */
        ((JComponent)table.getDefaultRenderer(Boolean.class)).setOpaque(true);     
        /**
         * Specify space of title Header [HEIGTH]
         */
        table.getTableHeader().setPreferredSize(new Dimension(0,30));
        table.setRowHeight(26);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(350);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public int addItem(DanhMuc objDM) {
        // thêm vào model
        alDanhMuc.add(objDM);
        this.fireTableDataChanged();
        /**- Cuộn đến dòng cuối **/
        table.scrollRectToVisible(table.getCellRect(this.getRowCount()-1, 0, true));
        return 1;
    }

    public int deleteItem(int id,int row) {
        // chuyển row view sang rowmodel
        int rowmodel = table.convertRowIndexToModel(row);
        alDanhMuc.remove(rowmodel);
        this.fireTableDataChanged();
        return 1;
    }
}
