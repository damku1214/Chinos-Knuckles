package net.damku1214.chinosknuckles.client;

public class ClientKnuckleDualWieldingData {
    private static boolean dualWielding;

    public static void set(boolean state) {
        ClientKnuckleDualWieldingData.dualWielding = state;
    }

    public static boolean get() {
        return dualWielding;
    }
}
