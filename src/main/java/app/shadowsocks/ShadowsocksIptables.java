package app.shadowsocks;

/**
 * iptables
 * @author    weiyinglei
 */

public class ShadowsocksIptables
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 91; i++)
        {
            System.out.println("-A INPUT -m state --state NEW -m tcp -p tcp --dport " + (9010 + i) + " -j ACCEPT");
        }
    }
}
