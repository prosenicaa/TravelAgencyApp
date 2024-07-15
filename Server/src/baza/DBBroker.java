/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repozitorijum.DBRepozitorijum;

/**
 *
 * @author Korisnik
 */
public class DBBroker<T extends OpstiDomenskiObjekat> implements DBRepozitorijum<T>{

    @Override
    public List<T> vratiSve(T param) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            
            sb.append("select ")
                    .append(param.vratiNaziveKolonaZaSelect())
                    .append(" from ")
                    .append(param.vratiImeTabele());
            
            String wheres = param.vratiWhereZaSelect();
            
            if(wheres.length() > 0) {
                sb.append(" where ")
                        .append(wheres);
            } 
            
            sb.append(";");
            
            String sql = sb.toString();
            
            Connection connection = Konekcija.getInstance().otvoriKonekciju();

            PreparedStatement statement = connection.prepareStatement(sql);
            
             if (!wheres.isEmpty()) {
                param.ubaciVrednostiZaSelectZaWehere(statement);
            }
            //param.ubaciVrednostiZaSelectZaWehere(statement);
            
            ResultSet rs = statement.executeQuery();
            
            List<T> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add((T) param.vratiRedIzRS(rs));
            }
            
            rs.close();
            
            statement.close();
            
            return lista;
        } catch (SQLException e) {
            System.out.println("u dbb greska");
            return null;
        }
    }

    @Override
    public void dodaj(OpstiDomenskiObjekat param) throws Exception {
        try {
            Connection connection = Konekcija.getInstance().otvoriKonekciju();
            
            String koloneZaDodavanje = param.vratiNaziveKolonaZaInsert();
            
            String[] cols = koloneZaDodavanje.split(",");
            for(int i = 0; i < cols.length; i++) {
                cols[i] = "?";
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("INSERT INTO ")
                    .append(param.vratiImeTabele())
                    .append(" (").append(koloneZaDodavanje).append(")")
                    .append(" VALUES (")
                    .append(String.join(",", cols))
                    .append(");");
            
            String query = sb.toString();
            
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            param.ubaciVrednostiZaInsert(statement);
            
            statement.executeUpdate();
            
            ResultSet rsKey = statement.getGeneratedKeys();
            
            if (rsKey.next()) {
                int id = rsKey.getInt(1);
                param.setId(id);
            }
            
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void izmeni(OpstiDomenskiObjekat param) throws Exception {
        try {
            Connection connection = Konekcija.getInstance().otvoriKonekciju();
            
            String koloneZaIzmenu = param.vratiNaziveKolonaZaUpdate();
            
            String[] kolone = koloneZaIzmenu.split(",");
            for(int i = 0; i < kolone.length; i++) {
                kolone[i] = kolone[i] + " = ?";
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("update ")
                    .append(param.vratiImeTabele())
                    .append(" set ")
                    .append(String.join(",", kolone))
                    .append(" where ")
                    .append(param.vratiWhereZaSelect());
                   
            
            String query = sb.toString();
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            param.ubaciVrednostiZaUpdate(statement);
            statement.setInt(kolone.length + 1, param.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void obrisi(OpstiDomenskiObjekat param) throws Exception {
        try {
            String sql = "delete from " + param.vratiImeTabele() + " where " + param.vratiWhereZaSelect();
            Connection connection = Konekcija.getInstance().otvoriKonekciju();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, param.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<T> vratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}