package so.water;

import java.io.IOException;

import database.Conn;

public class Timer extends Thread {
	public void run() {
		int i = 0;
		while (i < 5) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		Conn.getEntityManager().close();
		try {
			App.setRoot("primary");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
