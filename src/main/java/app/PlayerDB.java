package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;
import java.util.HashSet;
import java.util.Set;

public class PlayerDB {
    private static final long CACHE_DURATION_MIN = 10;
    private static final long CACHE_DURATION_MS = 1000*60*CACHE_DURATION_MIN;
    private Set<Player> cache;
    private long lastTime;
    private boolean cacheIsUpdate;

    private Connection connection;
    private final String DATA_BASE = "APP";
    private final String PLAYER_TAB = "PLAYER";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public PlayerDB() {
        cache = new HashSet<Player>();
        lastTime = System.currentTimeMillis();
        cacheIsUpdate = false;
    }

    public Set<Player> getPlayerSet() throws ClassNotFoundException, SQLException {
        if (System.currentTimeMillis() - lastTime > CACHE_DURATION_MIN) {
            cacheIsUpdate = false;
        }
        if (!cacheIsUpdate) {
            if (connection == null) {
                connectToDataBase();
            }
            Set<Player> playerSet = new HashSet<Player>();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM "+PLAYER_TAB;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Player player = new Player(rs.getString(0));
                playerSet.add(player);
            }
            lastTime = System.currentTimeMillis();
            cacheIsUpdate = true;
            cache = new HashSet<Player>(playerSet);

        }
		return cache;
	}

    public void add(Player player) throws ClassNotFoundException, SQLException {
        if (player == null) {
            throw new IllegalArgumentException("player");
        }
        if (connection == null) {
            connectToDataBase();
        }
        PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO "+PLAYER_TAB+" (nickname) VALUES (?)" );
		int nthPlaceholder = 1;
		preparedStatement.setString( nthPlaceholder++, player.getNickname());
        preparedStatement.executeUpdate();
        cache.add(player);
    }

    private void connectToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/"+DATA_BASE+"?user="+USER+"&password="+PASSWORD;
        connection = DriverManager.getConnection(connectionUrl);
    }
}