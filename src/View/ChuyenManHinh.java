/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author seape
 */
public class ChuyenManHinh {
    
    private JPanel root;
    private String kindSelected ="" ;
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinh(JPanel panelRoot) {
        this.root = panelRoot;
    }
    // xoa man hinh cu va chuyen sang man hinh moi
   public void setView(JPanel panelItem, JLabel labelItem ) throws SQLException{

      
       root.removeAll();
       root.setLayout(new BorderLayout());
       root.add(new Luong());
       root.validate();
       root.repaint();
   }
   
   public void setEvent(List<DanhMucBean> listItem){
       this.listItem = listItem;
       for(DanhMucBean item : listItem){
           item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(),item.getJlb()));
           
       }
       
   }
   // tao su kien click chuot cho label
   class LabelEvent implements MouseListener{
       
       private JPanel node ;
      
       private String kind ;
       private JPanel panel;
       private JLabel label ;

        public LabelEvent(String kind, JPanel panelItem, JLabel labelItem) {
            this.kind = kind;
            this.panel = panelItem;
            this.label = labelItem;
        }
       
       @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Phanmem":
                {
                    node = new Phanmem();
                }
                break;
                
                
                case "Tacnhan":
                    node = new Tacnhan();
                    break;
                case "Usecase":
                    node = new Usecase();
                    break;
                    
                case "KTCN":
                    node = new KTCN();
                    break;
                case "Noisuy":
                    node = new Noisuy();
                    break;
                case "Luong":
                    node = new Luong();
                    break;
                    
//                   case "PDF":
//                       node = new PDF();
//                       break;
//
//                       
//                   case "ExportExcelPanel":
//                       node = new ExportExcelPanel();
//                       break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
//            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind ;
//            jpnItem.setBackground(new Color(96,100, 191));
            label.setForeground(new Color(255,102,0));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
         label.setForeground(new Color(255, 255, 255));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            jpnItem.setBackground(new Color(96,100, 191));102, 204, 255
            label.setForeground(new Color(255, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind))
            {
//                jpnItem.setBackground(new Color(0,66,128));
                label.setBackground(new Color(255, 255, 255));
            }
        }
       
   }
   
   private void setChangeBackground(String kind ){
       for(DanhMucBean item : listItem){
           if(item.getKind().equalsIgnoreCase(kind)){
//               item.getJpn().setBackground(new Color(255,255,255));
               item.getJlb().setForeground(new Color(153, 204, 255));
           }
           else {
//               item.getJpn().setBackground(new Color(76,175,80));
               item.getJlb().setForeground(new Color(153, 204, 255));
           }
       }
   }
    
}

