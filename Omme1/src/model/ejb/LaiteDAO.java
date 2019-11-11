package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.Laite;

/**
 * Session Bean implementation class LaiteDAO
 */
@Stateless
@LocalBean
public class LaiteDAO {

	@Resource(name = "jdbc/laiteDB")
	private DataSource ds;

	public void addLaite(Laite laite) {
		String sql = "INSERT INTO LAITE VALUES('" + laite.getLaitteenID()
				+ "', '" + laite.getNimi() + "', '" + laite.getKuvaus()
				+ "', '" + laite.getHinta() + "', '"
				+ laite.getOstopäivämäärä() + "', '" + laite.getTakuu() + "')";
	}

	public void editLaite(Laite laite) {
		String sql = "UPDATE LAITE SET NAME='" + laite.getNimi()
				+ "', KUVAUS='" + laite.getKuvaus() + "',HINTA='"
				+ laite.getHinta() + "',OSTOPÄIVÄMÄÄRÄ='"
				+ laite.getOstopäivämäärä() + "',TAKUU='" + laite.getTakuu()
				+ "' WHERE LAITTEENID='" + laite.getLaitteenID() + "'";
		executeModifyQuery(sql);
	}

	public void deleteLaite(Laite laite) {
		String sql = "DELETE FROM LAITE WHERE LAITTEENID='"
				+ laite.getLaitteenID() + "'";
		executeModifyQuery(sql);
	}

	public Laite getLaite(String id) {
		Laite laite = new Laite();
		String sql = "SELECT * FROM LAITE WHERELAITTEENID='" + id + "'";
		System.out.println(sql);
		ResultSet rs = executeFetchQuery(sql);
		try {
			if (rs.next()) {
				laite.setLaitteenID(rs.getString("LAITTEENID"));
				laite.setNimi(rs.getString("NIMI"));
				laite.setKuvaus(rs.getString("KUVAUS"));
				laite.setHinta(rs.getDouble("HINTA"));
				laite.setOstopäivämäärä(rs.getInt("OSTOPÄIVÄMÄÄRÄ"));
				laite.setTakuu(rs.getInt("TAKUU"));

			}
		} catch (Exception ex) {
			System.err.println("GS" + ex.getMessage());

		}
		return laite;
	}

	public ArrayList<Laite> getKaikkiLaitteet() {
		ArrayList<Laite> list = new ArrayList<Laite>();
		String sql = "SELECT * FROM LAITE";
		ResultSet rs = executeFetchQuery(sql);
		try {
			while (rs.next()) {
				Laite laite = new Laite();
				laite.setLaitteenID(rs.getString("LAITTEENID"));
				laite.setNimi(rs.getString("NIMI"));
				laite.setKuvaus(rs.getString("KUVAUS"));
				laite.setHinta(rs.getDouble("HINTA"));
				laite.setOstopäivämäärä(rs.getInt("OSTOPÄIVÄMÄÄRÄ"));
				laite.setTakuu(rs.getInt("TAKUU"));
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());

		}
		return list;

	}

	public void executeModifyQuery(String sql) {

		try {
			Connection conn = ((Statement) ds).getConnection();
			conn.createStatement().execute(sql);
			conn.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public ResultSet executeFetchQuery(String sql) {

		ResultSet rs = null;

		try {
			Connection conn = ((Statement) ds).getConnection();
			rs = conn.createStatement().executeQuery(sql);
			conn.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
