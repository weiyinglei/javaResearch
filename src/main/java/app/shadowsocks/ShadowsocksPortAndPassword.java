package app.shadowsocks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * port and password
 * @author    weiyinglei
 */

public class ShadowsocksPortAndPassword
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++)
        {
            UUID uuid = UUID.randomUUID();
            list.add(uuid.toString().split("-")[0]);
        }
        System.out.println(list.size());
        
        for (int i = 0; i < 100; i++)
        {
            System.out.println("\"" + (9001 + i) + "\": \"" + list.get(i) + "\",");
        }
    }
}

