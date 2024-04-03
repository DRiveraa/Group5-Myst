package application.model.server_impl.game;

import org.json.JSONArray;
import org.json.JSONObject;

import application.fileIO.GameLibraryIO;
import application.model.local_impl.game.GameLibrary;
import application.model.server_impl.Server;

public class GameLibraryManager {
    
    /**
     * Fetch and parse game library.
     *
     * @return the game library
     */
    public static GameLibrary fetchAndParseGameLibrary() {
        try {
            JSONObject requestJson = new JSONObject();
            requestJson.put("request_type", "get_game_library");
            
            String response = Server.sendRequest(requestJson.toString());
            JSONObject jsonResponse = new JSONObject(response);
            
            if (jsonResponse.getBoolean("success")) {
                JSONArray gamesArray = jsonResponse.getJSONArray("games");
                return GameLibraryIO.parseGamesFromJson(gamesArray);
            } 
        } catch (Exception e) {
            throw new IllegalArgumentException("Error fetching or parsing game library: " + e.getMessage());
        }
        return null;
    }
}