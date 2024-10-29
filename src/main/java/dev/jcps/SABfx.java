package dev.jcps;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;
import java.util.StringTokenizer;


public final class SABfx extends JPanel implements Runnable, JavaAppletAdapter {
    private static Socket sock;
    private static DataInputStream in;
    private static PrintStream out;
    private static int myRegions;
    private static int moreRin;
    private static int moreRex;
    private static int moreDn;
    private static int moreRem;
    private static int vspc;
    private static int rd;
    private static int gn;
    private static int bl;
    private static int br;
    private static int brnd;
    private static Color[] clrs;
    private static String serverName;
    private static String serverPath;
    private static String cgiData;
    private static Thread aniThread;
    private static String scriptName;
    private static String playerName;
    private static String scriptSfx;
    private static Clip quiet;
    private static Clip[] sfx;
    private static int vpt;
    private static int noClick;
    private static int busy;
    private static int tx;
    private static int tstr;
    private static int loadingScript;
    private static int syntax;
    private static MediaTracker tracker;
    private static int redBall;
    private static int tiH;
    private static int tiW;
    private static int tiR;
    private static int tiG;
    private static int tiB;
    private static int ti13;
    private static int moreUp;
    private static int[] ps;
    private static long STCM;
    private static int STCMP;
    private static int miceDown;
    private static int miceUp;
    private static int miceMove;
    private static int miceDrag;
    private static int miceX;
    private static int miceY;
    private static int depth;
    private static int depth2;
    private static int depth1;
    private static int lxSize;
    private static int lySize;
    private static int aniClock;
    private static Image tile;
    private static Image gold;
    private static Image working;
    private static long[] macTime;
    private static int[] macNumber;
    private static String[] Macro;
    private static String[] Array;
    private static String MYData;
    private static Image[] Images;
    private static Font[] myFont;
    private static String[] myStr;
    private static Font f;
    private static int[] RegionActive;
    private static int[] RegionInside;
    private static int[] RegionFlag;
    private static int[] RegionX;
    private static int[] RegionY;
    private static int[] RegionWidth;
    private static int[] RegionHeight;
    private static String[] RegionDown;
    private static String[] RegionUp;
    private static String[] RegionEnter;
    private static String[] RegionExit;
    private static int tiR2;
    private static int tiG2;
    private static int tiB2;
    private static int opcode;
    private static int runDrop;
    private static int operand1;
    private static int operand2;
    private static int operand3;
    private static int operand4;
    private static int operand5;
    private static int operand6;
    private static String chop;
    private static String chop2;
    private static String chop3;
    private static String chop4;
    private static String rdata;
    private static String csData;
    private static String sabRdata;
    private static String macRdata;
    private static int moreData;
    private static int Regions;
    private static int refresh;
    private static int plane;
    private static Frame frame;
    private static int cursor;
    private static int clickIt;

    static {
        SABfx.sock = null;
        SABfx.in = null;
        SABfx.out = null;
        SABfx.myRegions = 101;
        SABfx.moreRin = 1;
        SABfx.moreRex = 1;
        SABfx.moreDn = 1;
        SABfx.moreRem = 1;
        SABfx.clrs = new Color[128];
        SABfx.serverName = "";
        SABfx.serverPath = "";
        SABfx.cgiData = "";
        SABfx.aniThread = null;
        SABfx.scriptName = "";
        SABfx.playerName = "";
        SABfx.scriptSfx = "";
        SABfx.sfx = new Clip[100];
        SABfx.vpt = 12;
        SABfx.noClick = 1;
        SABfx.tiH = 1;
        SABfx.tiW = 1;
        SABfx.tiR = 1;
        SABfx.tiG = 1;
        SABfx.tiB = 1;
        SABfx.moreUp = 1;
        SABfx.ps = new int[101];
        SABfx.aniClock = 1;
        SABfx.macTime = new long[101];
        SABfx.macNumber = new int[101];
        SABfx.Macro = new String[101];
        SABfx.Array = new String[1001];
        SABfx.MYData = "";
        SABfx.Images = new Image[102];
        SABfx.myFont = new Font[101];
        SABfx.myStr = new String[102];
        SABfx.f = new Font("Helvetica", Font.PLAIN, 12);
        SABfx.RegionActive = new int[101];
        SABfx.RegionInside = new int[102];
        SABfx.RegionFlag = new int[110];
        SABfx.RegionX = new int[101];
        SABfx.RegionY = new int[101];
        SABfx.RegionWidth = new int[102];
        SABfx.RegionHeight = new int[102];
        SABfx.RegionDown = new String[102];
        SABfx.RegionUp = new String[102];
        SABfx.RegionEnter = new String[102];
        SABfx.RegionExit = new String[102];
        SABfx.opcode = 999;
        SABfx.operand1 = 999;
        SABfx.operand2 = 999;
        SABfx.operand3 = 999;
        SABfx.operand4 = 999;
        SABfx.operand5 = 999;
        SABfx.operand6 = 999;
        SABfx.chop = "";
        SABfx.chop2 = "";
        SABfx.chop3 = "";
        SABfx.chop4 = "";
        SABfx.rdata = "";
        SABfx.csData = "";
        SABfx.sabRdata = "";
        SABfx.macRdata = "";
        SABfx.moreData = 1;
        SABfx.refresh = 1;
        SABfx.plane = 2;
        SABfx.cursor = 3;
        SABfx.clickIt = 2;
    }

    final String SAB1998 = "BS";
    final String SAB = "SB";
    final String endo = "(";

    public void init() {
        Container container;
        for (container = this.getParent(); container != null && !(container instanceof Frame); ) {
            container = container.getParent();
        }
        SABfx.frame = (Frame) container;
        SABfx.clickIt = 2;
        SABfx.cursor = 3;
        assert SABfx.frame != null;
        SABfx.frame.setCursor(SABfx.cursor);
        SABfx.refresh = 1;
        SABfx.tracker = new MediaTracker(this);
        SABfx.vspc = 0;
        SABfx.miceDrag = 0;
        SABfx.miceDown = 0;
        SABfx.miceUp = 0;
        SABfx.miceMove = 0;
        for (int i = 0; i < 101; ++i) {
            SABfx.myFont[i] = null;
            SABfx.macTime[i] = 0L;
            SABfx.macNumber[i] = 0;
            SABfx.Macro[i] = "SB+";
            SABfx.RegionActive[i] = 0;
            SABfx.RegionInside[i] = 0;
            SABfx.RegionX[i] = 0;
            SABfx.RegionY[i] = 0;
            SABfx.RegionWidth[i] = 0;
            SABfx.RegionHeight[i] = 0;
            SABfx.RegionDown[i] = "";
            SABfx.RegionUp[i] = "";
            SABfx.RegionEnter[i] = "";
            SABfx.RegionExit[i] = "";
        }
        if (SABfx.loadingScript == 1) {
            return;
        }
        this.setBackground(Color.black);
        this.setForeground(Color.black);
        SABfx.scriptName = this.getParameter("scriptname");
        SABfx.lxSize = this.getSize().width;
        SABfx.lySize = this.getSize().height;
        SABfx.working = this.createImage(SABfx.lxSize, SABfx.lySize);
        SABfx.tile = this.createImage(10, 10);
        SABfx.ti13 = 101;
        SABfx.tiW = 1;
        SABfx.tiH = 1;
        SABfx.Images[SABfx.ti13] = this.createImage(SABfx.tiW, SABfx.tiH);
        SABfx.Images[SABfx.ti13].getGraphics().dispose();
        try {
            SABfx.scriptSfx = this.getParameter("sfx");
            if (!SABfx.scriptSfx.isEmpty()) {
                SABfx.scriptSfx += ".au";
                (SABfx.quiet = this.getAudioClip(this.getDocumentBase(), SABfx.scriptSfx)).stop();
                SABfx.quiet.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (final Exception ignored) {
        }
        try {
            SABfx.myStr[100] = this.getParameter("playername");
            SABfx.serverName = this.getParameter("serverName");
            SABfx.serverPath = this.getParameter("serverpath");
        } catch (final Exception ignored) {
        }
        SABfx.scriptName += ".sbx";
        try {
            final DataInputStream dataInputStream = new DataInputStream(new URL(this.getDocumentBase()).openStream());
            SABfx.sabRdata = "";
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                SABfx.sabRdata += line;
            }
            dataInputStream.close();
        } catch (final Exception ignored) {
        }
    }

    public String getString(final StringTokenizer stringTokenizer) {
        String s = "";
        if (stringTokenizer.hasMoreTokens()) {
            s = stringTokenizer.nextToken();
        }
        while (s.charAt(s.length() - 1) == '(') {
            final String string = s.substring(0, s.length() - 1) + "+";
            if (stringTokenizer.hasMoreTokens()) {
                SABfx.chop = stringTokenizer.nextToken();
            }
            s = string + SABfx.chop.substring(1);
        }
        return s;
    }

    public int getValue(String substring) {
        try {
            SABfx.tstr = Integer.parseInt(substring);
        } catch (final Exception ex) {
            substring = substring.substring(1);
            SABfx.tstr = Integer.parseInt(substring);
            SABfx.tstr = SABfx.RegionFlag[SABfx.tstr];
        }
        return SABfx.tstr;
    }

    public int getRegister(String substring) {
        try {
            SABfx.tstr = Integer.parseInt(substring);
        } catch (final Exception ex) {
            substring = substring.substring(1);
            SABfx.tstr = Integer.parseInt(substring);
        }
        return SABfx.tstr;
    }

    @Override
    public void update(final Graphics graphics) {
        SABfx.redBall = 1;
        this.paint(graphics);
        SABfx.redBall = 0;
    }

    @Override
    public void paint(final Graphics graphics) {
        if (SABfx.redBall == 0) {
            return;
        }
        SABfx.STCM = System.currentTimeMillis();
        SABfx.RegionFlag[100] = SABfx.miceX;
        SABfx.RegionFlag[101] = SABfx.miceY;
        final Graphics graphics2 = SABfx.working.getGraphics();
        Graphics graphics3 = SABfx.Images[SABfx.ti13].getGraphics();
        if (!SABfx.macRdata.isEmpty()) {
            SABfx.sabRdata += SABfx.macRdata;
            SABfx.macRdata = "";
        }
        if (!SABfx.sabRdata.isEmpty()) {
            SABfx.rdata = SABfx.sabRdata;
        }
        SABfx.sabRdata = "";
        SABfx.refresh = 0;
        final StringTokenizer stringTokenizer = new StringTokenizer(SABfx.rdata, "+");
        SABfx.moreData = 1;
        while (SABfx.moreData == 1) {
            SABfx.chop = "";
            SABfx.opcode = 999;
            if (stringTokenizer.hasMoreTokens()) {
                SABfx.chop = stringTokenizer.nextToken();
            }
            if ("SB".equalsIgnoreCase(SABfx.chop)) {
                SABfx.opcode = 38;
            }
            if (SABfx.chop.length() == 1 && SABfx.chop.charAt(0) == '[') {
                SABfx.opcode = 95;
            }
            if (SABfx.opcode == 999 && !SABfx.chop.isEmpty()) {
                SABfx.opcode = Integer.parseInt(SABfx.chop);
            }
            Label_17871:
            {
                switch (SABfx.opcode) {
                    case 63: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getRegister(SABfx.chop);
                        SABfx.RegionFlag[SABfx.operand1] = -SABfx.RegionFlag[SABfx.operand1];
                        break;
                    }
                    case 49: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        final int[] regionFlag = SABfx.RegionFlag;
                        final int operand1 = SABfx.operand1;
                        ++regionFlag[operand1];
                        break;
                    }
                    case 50: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        final int[] regionFlag2 = SABfx.RegionFlag;
                        final int operand2 = SABfx.operand1;
                        --regionFlag2[operand2];
                        break;
                    }
                    case 51: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.RegionFlag[SABfx.operand1] = SABfx.operand2;
                        break;
                    }
                    case 52: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        final int[] regionFlag3 = SABfx.RegionFlag;
                        final int operand3 = SABfx.operand1;
                        regionFlag3[operand3] += SABfx.operand2;
                        break;
                    }
                    case 53: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        final int[] regionFlag4 = SABfx.RegionFlag;
                        final int operand4 = SABfx.operand1;
                        regionFlag4[operand4] -= SABfx.operand2;
                        break;
                    }
                    case 54: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        final int[] regionFlag5 = SABfx.RegionFlag;
                        final int operand5 = SABfx.operand1;
                        regionFlag5[operand5] *= SABfx.operand2;
                        break;
                    }
                    case 55: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (SABfx.operand2 == 0) {
                            SABfx.operand2 = 1;
                        }
                        final int[] regionFlag6 = SABfx.RegionFlag;
                        final int operand6 = SABfx.operand1;
                        regionFlag6[operand6] /= SABfx.operand2;
                        break;
                    }
                    case 80: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getRegister(SABfx.chop) % 101;
                        SABfx.RegionActive[SABfx.operand1] = 1;
                        break;
                    }
                    case 81: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getRegister(SABfx.chop) % 101;
                        SABfx.RegionActive[SABfx.operand1] = 0;
                        break;
                    }
                    case 56: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (SABfx.operand2 == 0) {
                            SABfx.operand2 = 1;
                        }
                        final int[] regionFlag7 = SABfx.RegionFlag;
                        final int operand7 = SABfx.operand1;
                        regionFlag7[operand7] %= SABfx.operand2;
                        break;
                    }
                    case 57: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionFlag[SABfx.operand1] = (int) (Math.random() * 65536.0);
                        break;
                    }
                    case 58: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (SABfx.RegionFlag[SABfx.operand1] != SABfx.operand2) {
                            SABfx.moreUp = 1;
                            while (SABfx.moreUp == 1) {
                                if (stringTokenizer.hasMoreTokens()) {
                                    SABfx.chop = stringTokenizer.nextToken();
                                }
                                if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                    SABfx.moreUp = 0;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 59: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (SABfx.RegionFlag[SABfx.operand1] == SABfx.operand2) {
                            SABfx.moreUp = 1;
                            while (SABfx.moreUp == 1) {
                                if (stringTokenizer.hasMoreTokens()) {
                                    SABfx.chop = stringTokenizer.nextToken();
                                }
                                if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                    SABfx.moreUp = 0;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 60: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (SABfx.RegionFlag[SABfx.operand1] <= SABfx.operand2) {
                            SABfx.moreUp = 1;
                            while (SABfx.moreUp == 1) {
                                if (stringTokenizer.hasMoreTokens()) {
                                    SABfx.chop = stringTokenizer.nextToken();
                                }
                                if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                    SABfx.moreUp = 0;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 61: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (SABfx.RegionFlag[SABfx.operand1] >= SABfx.operand2) {
                            SABfx.moreUp = 1;
                            while (SABfx.moreUp == 1) {
                                if (stringTokenizer.hasMoreTokens()) {
                                    SABfx.chop = stringTokenizer.nextToken();
                                }
                                if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                    SABfx.moreUp = 0;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 0: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (SABfx.RegionFlag[SABfx.operand1] == 0) {
                            SABfx.moreUp = 1;
                            while (SABfx.moreUp == 1) {
                                if (stringTokenizer.hasMoreTokens()) {
                                    SABfx.chop = stringTokenizer.nextToken();
                                }
                                if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                    SABfx.moreUp = 0;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 1: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (SABfx.RegionFlag[SABfx.operand1] != 0) {
                            SABfx.moreUp = 1;
                            while (SABfx.moreUp == 1) {
                                if (stringTokenizer.hasMoreTokens()) {
                                    SABfx.chop = stringTokenizer.nextToken();
                                }
                                if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                    SABfx.moreUp = 0;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 15: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionFlag[SABfx.operand1] = (SABfx.RegionFlag[SABfx.operand1] + 1) % 2;
                        break;
                    }
                    case 3: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiR = this.getValue(SABfx.chop) % 256;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiG = this.getValue(SABfx.chop) % 256;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiB = this.getValue(SABfx.chop) % 256;
                        break;
                    }
                    case 64: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiR2 = this.getValue(SABfx.chop) % 256;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiG2 = this.getValue(SABfx.chop) % 256;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiB2 = this.getValue(SABfx.chop) % 256;
                        break;
                    }
                    case 79: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.plane = this.getValue(SABfx.chop);
                        break;
                    }
                    case 9: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 21: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                graphics3.drawString(SABfx.chop, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                graphics2.drawString(SABfx.chop, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                graphics.drawString(SABfx.chop, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 5: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.drawImage(SABfx.Images[SABfx.operand1], SABfx.operand2, SABfx.operand3, null);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.drawImage(SABfx.Images[SABfx.operand1], SABfx.operand2, SABfx.operand3, null);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.drawImage(SABfx.Images[SABfx.operand1], SABfx.operand2, SABfx.operand3, null);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 78: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand5 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand6 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.drawImage(SABfx.Images[SABfx.operand1], SABfx.operand2, SABfx.operand3, SABfx.operand5, SABfx.operand6, null);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.drawImage(SABfx.Images[SABfx.operand1], SABfx.operand2, SABfx.operand3, SABfx.operand5, SABfx.operand6, null);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.drawImage(SABfx.Images[SABfx.operand1], SABfx.operand2, SABfx.operand3, SABfx.operand5, SABfx.operand6, null);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 48: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        this.showStatus(SABfx.chop);
                        break;
                    }
                    case 90: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.Images[SABfx.operand1] = this.getImage(this.getDocumentBase(), SABfx.chop);
                        SABfx.tracker.addImage(SABfx.Images[SABfx.operand1], SABfx.operand1);
                        try {
                            SABfx.tracker.waitForID(SABfx.operand1);
                        } catch (final InterruptedException ignored) {
                            // ignored
                        }
                        break;
                    }
                    case 92: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop) % 101;
                        SABfx.RegionInside[SABfx.operand1] = 0;
                        SABfx.RegionDown[SABfx.operand1] = "";
                        SABfx.RegionUp[SABfx.operand1] = "";
                        SABfx.RegionEnter[SABfx.operand1] = "";
                        SABfx.RegionExit[SABfx.operand1] = "";
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.RegionX[SABfx.operand1] = SABfx.operand2;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.RegionY[SABfx.operand1] = SABfx.operand2;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.RegionWidth[SABfx.operand1] = SABfx.operand2;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.RegionHeight[SABfx.operand1] = SABfx.operand2;
                        SABfx.RegionActive[SABfx.operand1] = 1;
                        break;
                    }
                    case 93: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionEnter[SABfx.operand1] = "";
                        SABfx.moreRin = 1;
                        while (SABfx.moreRin == 1) {
                            if (stringTokenizer.hasMoreTokens()) {
                                SABfx.chop = stringTokenizer.nextToken();
                            }
                            if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                SABfx.moreRin = 0;
                            }
                            if (SABfx.moreRin > 0) {
                                final String[] regionEnter = SABfx.RegionEnter;
                                final int operand8 = SABfx.operand1;
                                regionEnter[operand8] = regionEnter[operand8] + SABfx.chop + "+";
                            }
                        }
                        final String[] regionEnter2 = SABfx.RegionEnter;
                        final int operand9 = SABfx.operand1;
                        regionEnter2[operand9] += "SB+";
                        break;
                    }
                    case 94: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionExit[SABfx.operand1] = "";
                        SABfx.moreRex = 1;
                        while (SABfx.moreRex == 1) {
                            if (stringTokenizer.hasMoreTokens()) {
                                SABfx.chop = stringTokenizer.nextToken();
                            }
                            if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                SABfx.moreRex = 0;
                            }
                            if (SABfx.moreRex > 0) {
                                final String[] regionExit = SABfx.RegionExit;
                                final int operand10 = SABfx.operand1;
                                regionExit[operand10] = regionExit[operand10] + SABfx.chop + "+";
                            }
                        }
                        final String[] regionExit2 = SABfx.RegionExit;
                        final int operand11 = SABfx.operand1;
                        regionExit2[operand11] += "SB+";
                        break;
                    }
                    case 95: {
                        SABfx.moreRem = 1;
                        SABfx.chop = "";
                        while (SABfx.moreRem == 1) {
                            if (stringTokenizer.hasMoreTokens()) {
                                SABfx.chop = stringTokenizer.nextToken();
                            } else {
                                SABfx.moreRem = 0;
                            }
                            if (SABfx.chop.length() == 1 && SABfx.chop.charAt(0) == ']') {
                                SABfx.moreRem = 0;
                            }
                        }
                        break;
                    }
                    case 7: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.drawImage(SABfx.Images[SABfx.operand2], SABfx.RegionX[SABfx.operand1], SABfx.RegionY[SABfx.operand1], null);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.drawImage(SABfx.Images[SABfx.operand2], SABfx.RegionX[SABfx.operand1], SABfx.RegionY[SABfx.operand1], null);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.drawImage(SABfx.Images[SABfx.operand2], SABfx.RegionX[SABfx.operand1], SABfx.RegionY[SABfx.operand1], null);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 8: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        --SABfx.operand3;
                        if (SABfx.operand3 < 1) {
                            SABfx.operand3 = 1;
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        --SABfx.operand4;
                        if (SABfx.operand4 < 1) {
                            SABfx.operand4 = 1;
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.depth = this.getValue(SABfx.chop);
                        if (SABfx.depth < 1) {
                            SABfx.depth = 1;
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                if (SABfx.operand4 < (SABfx.operand3 + 1) / 2) {
                                    for (int i = SABfx.operand3; i > 0; --i) {
                                        SABfx.depth1 = (SABfx.operand3 - i) * SABfx.depth % SABfx.operand3;
                                        SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                        graphics3.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                        graphics3.drawRect(SABfx.operand3 / 2 + SABfx.operand1 - i / 2, SABfx.operand2 + SABfx.operand4 / 4 - SABfx.operand4 / 4 * i / SABfx.operand3, i, SABfx.operand4 * i / SABfx.operand3);
                                    }
                                    break Label_17871;
                                }
                                for (int j = SABfx.operand4; j > 0; --j) {
                                    SABfx.depth1 = (SABfx.operand4 - j) * SABfx.depth % SABfx.operand4;
                                    SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                    graphics3.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                    graphics3.drawRect(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * j / SABfx.operand4 / 2, SABfx.operand2 - j / 4 + SABfx.operand4 / 4, SABfx.operand3 * j / SABfx.operand4, j);
                                }
                                break Label_17871;
                            }
                            case 2: {
                                if (SABfx.operand4 < (SABfx.operand3 + 1) / 2) {
                                    for (int k = SABfx.operand3; k > 0; --k) {
                                        SABfx.depth1 = (SABfx.operand3 - k) * SABfx.depth % SABfx.operand3;
                                        SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                        graphics2.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                        graphics2.drawRect(SABfx.operand3 / 2 + SABfx.operand1 - k / 2, SABfx.operand2 + SABfx.operand4 / 4 - SABfx.operand4 / 4 * k / SABfx.operand3, k, SABfx.operand4 * k / SABfx.operand3);
                                    }
                                    break Label_17871;
                                }
                                for (int l = SABfx.operand4; l > 0; --l) {
                                    SABfx.depth1 = (SABfx.operand4 - l) * SABfx.depth % SABfx.operand4;
                                    SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                    graphics2.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                    graphics2.drawRect(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * l / SABfx.operand4 / 2, SABfx.operand2 - l / 4 + SABfx.operand4 / 4, SABfx.operand3 * l / SABfx.operand4, l);
                                }
                                break Label_17871;
                            }
                            case 3: {
                                if (SABfx.operand4 < (SABfx.operand3 + 1) / 2) {
                                    for (int operand12 = SABfx.operand3; operand12 > 0; --operand12) {
                                        SABfx.depth1 = (SABfx.operand3 - operand12) * SABfx.depth % SABfx.operand3;
                                        SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                        graphics.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                        graphics.drawRect(SABfx.operand3 / 2 + SABfx.operand1 - operand12 / 2, SABfx.operand2 + SABfx.operand4 / 4 - SABfx.operand4 / 4 * operand12 / SABfx.operand3, operand12, SABfx.operand4 * operand12 / SABfx.operand3);
                                    }
                                    break Label_17871;
                                }
                                for (int operand13 = SABfx.operand4; operand13 > 0; --operand13) {
                                    SABfx.depth1 = (SABfx.operand4 - operand13) * SABfx.depth % SABfx.operand4;
                                    SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                    graphics.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                    graphics.drawRect(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * operand13 / SABfx.operand4 / 2, SABfx.operand2 - operand13 / 4 + SABfx.operand4 / 4, SABfx.operand3 * operand13 / SABfx.operand4, operand13);
                                }
                                graphics.fillRect(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * 2 / SABfx.operand4 / 2, SABfx.operand2 + SABfx.operand4 / 4, SABfx.operand3 * 2 / SABfx.operand4 + 1, 3);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 65: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        --SABfx.operand2;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        --SABfx.operand3;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        if (SABfx.operand4 < 1) {
                            SABfx.operand4 = 1;
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.depth = this.getValue(SABfx.chop);
                        if (SABfx.depth < 1) {
                            SABfx.depth = 1;
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                for (int operand14 = SABfx.operand4; operand14 > 0; --operand14) {
                                    SABfx.depth1 = (SABfx.operand4 - operand14) * SABfx.depth % SABfx.operand4;
                                    SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                    graphics3.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                    graphics3.drawLine(SABfx.operand1, SABfx.operand2 + operand14, SABfx.operand3 + SABfx.operand1, SABfx.operand2 + operand14);
                                }
                                break Label_17871;
                            }
                            case 2: {
                                for (int operand15 = SABfx.operand4; operand15 > 0; --operand15) {
                                    SABfx.depth1 = (SABfx.operand4 - operand15) * SABfx.depth % SABfx.operand4;
                                    SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                    graphics2.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                    graphics2.drawLine(SABfx.operand1, SABfx.operand2 + operand15, SABfx.operand3 + SABfx.operand1, SABfx.operand2 + operand15);
                                }
                                break Label_17871;
                            }
                            case 3: {
                                for (int operand16 = SABfx.operand4; operand16 > 0; --operand16) {
                                    SABfx.depth1 = (SABfx.operand4 - operand16) * SABfx.depth % SABfx.operand4;
                                    SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                    graphics.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                    graphics.drawLine(SABfx.operand1, SABfx.operand2 + operand16, SABfx.operand3 + SABfx.operand1, SABfx.operand2 + operand16);
                                }
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 66: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        --SABfx.operand1;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (SABfx.operand3 < 1) {
                            SABfx.operand3 = 1;
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        --SABfx.operand4;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.depth = this.getValue(SABfx.chop);
                        if (SABfx.depth < 1) {
                            SABfx.depth = 1;
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                for (int operand17 = SABfx.operand3; operand17 > 0; --operand17) {
                                    SABfx.depth1 = (SABfx.operand3 - operand17) * SABfx.depth % SABfx.operand3;
                                    SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                    graphics3.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                    graphics3.drawLine(SABfx.operand1 + operand17, SABfx.operand2, SABfx.operand1 + operand17, SABfx.operand2 + SABfx.operand4);
                                }
                                break Label_17871;
                            }
                            case 2: {
                                for (int operand18 = SABfx.operand3; operand18 > 0; --operand18) {
                                    SABfx.depth1 = (SABfx.operand3 - operand18) * SABfx.depth % SABfx.operand3;
                                    SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                    graphics2.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                    graphics2.drawLine(SABfx.operand1 + operand18, SABfx.operand2, SABfx.operand1 + operand18, SABfx.operand2 + SABfx.operand4);
                                }
                                break Label_17871;
                            }
                            case 3: {
                                for (int operand19 = SABfx.operand3; operand19 > 0; --operand19) {
                                    SABfx.depth1 = (SABfx.operand3 - operand19) * SABfx.depth % SABfx.operand3;
                                    SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                    graphics.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                    graphics.drawLine(SABfx.operand1 + operand19, SABfx.operand2, SABfx.operand1 + operand19, SABfx.operand2 + SABfx.operand4);
                                }
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 67: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.copyArea(-SABfx.operand1, -SABfx.operand2, SABfx.tiW - SABfx.operand1, SABfx.tiH - SABfx.operand2, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.copyArea(-SABfx.operand1, -SABfx.operand2, SABfx.lxSize - SABfx.operand1, SABfx.lySize - SABfx.operand2, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.copyArea(-SABfx.operand1, -SABfx.operand2, SABfx.lxSize - SABfx.operand1, SABfx.lySize - SABfx.operand2, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 68: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.clipRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.clipRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.clipRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 2: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (SABfx.operand3 < 1) {
                            SABfx.operand3 = 1;
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        if (SABfx.operand4 < 1) {
                            SABfx.operand4 = 1;
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.depth = this.getValue(SABfx.chop);
                        if (SABfx.depth < 1) {
                            SABfx.depth = 1;
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                if (SABfx.operand4 < SABfx.operand3 / 2) {
                                    for (int operand20 = SABfx.operand3; operand20 > 0; operand20 -= 2) {
                                        if (operand20 / 2 % 2 == 0 || SABfx.operand3 == operand20) {
                                            SABfx.depth1 = (SABfx.operand3 - operand20) * SABfx.depth % SABfx.operand3;
                                            SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                            graphics3.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                            graphics3.fillOval(SABfx.operand3 / 2 + SABfx.operand1 - operand20 / 2, SABfx.operand2 + SABfx.operand4 / 4 - SABfx.operand4 / 4 * operand20 / SABfx.operand3, operand20, SABfx.operand4 * operand20 / SABfx.operand3);
                                        }
                                    }
                                    break Label_17871;
                                }
                                for (int operand21 = SABfx.operand4; operand21 > 0; operand21 -= 2) {
                                    if (operand21 / 2 % 2 == 0 || SABfx.operand4 == operand21) {
                                        SABfx.depth1 = (SABfx.operand4 - operand21) * SABfx.depth % SABfx.operand4;
                                        SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                        graphics3.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                        graphics3.fillOval(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * operand21 / SABfx.operand4 / 2, SABfx.operand2 - operand21 / 4 + SABfx.operand4 / 4, SABfx.operand3 * operand21 / SABfx.operand4, operand21);
                                    }
                                }
                                break Label_17871;
                            }
                            case 2: {
                                if (SABfx.operand4 < SABfx.operand3 / 2) {
                                    for (int operand22 = SABfx.operand3; operand22 > 0; operand22 -= 2) {
                                        if (operand22 / 2 % 2 == 0 || SABfx.operand3 == operand22) {
                                            SABfx.depth1 = (SABfx.operand3 - operand22) * SABfx.depth % SABfx.operand3;
                                            SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                            graphics2.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                            graphics2.fillOval(SABfx.operand3 / 2 + SABfx.operand1 - operand22 / 2, SABfx.operand2 + SABfx.operand4 / 4 - SABfx.operand4 / 4 * operand22 / SABfx.operand3, operand22, SABfx.operand4 * operand22 / SABfx.operand3);
                                        }
                                    }
                                    break Label_17871;
                                }
                                for (int operand23 = SABfx.operand4; operand23 > 0; operand23 -= 2) {
                                    if (operand23 / 2 % 2 == 0 || SABfx.operand4 == operand23) {
                                        SABfx.depth1 = (SABfx.operand4 - operand23) * SABfx.depth % SABfx.operand4;
                                        SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                        graphics2.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                        graphics2.fillOval(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * operand23 / SABfx.operand4 / 2, SABfx.operand2 - operand23 / 4 + SABfx.operand4 / 4, SABfx.operand3 * operand23 / SABfx.operand4, operand23);
                                    }
                                }
                                break Label_17871;
                            }
                            case 3: {
                                if (SABfx.operand4 < SABfx.operand3 / 2) {
                                    for (int operand24 = SABfx.operand3; operand24 > 0; operand24 -= 2) {
                                        if (operand24 / 2 % 2 == 0 || SABfx.operand3 == operand24) {
                                            SABfx.depth1 = (SABfx.operand3 - operand24) * SABfx.depth % SABfx.operand3;
                                            SABfx.depth2 = SABfx.operand3 - SABfx.depth1;
                                            graphics.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand3 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand3, SABfx.tiG * SABfx.depth1 / SABfx.operand3 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand3, SABfx.tiB * SABfx.depth1 / SABfx.operand3 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand3));
                                            graphics.fillOval(SABfx.operand3 / 2 + SABfx.operand1 - operand24 / 2, SABfx.operand2 + SABfx.operand4 / 4 - SABfx.operand4 / 4 * operand24 / SABfx.operand3, operand24, SABfx.operand4 * operand24 / SABfx.operand3);
                                        }
                                    }
                                    break Label_17871;
                                }
                                for (int operand25 = SABfx.operand4; operand25 > 0; operand25 -= 2) {
                                    if (operand25 / 2 % 2 == 0 || SABfx.operand4 == operand25) {
                                        SABfx.depth1 = (SABfx.operand4 - operand25) * SABfx.depth % SABfx.operand4;
                                        SABfx.depth2 = SABfx.operand4 - SABfx.depth1;
                                        graphics.setColor(new Color(SABfx.tiR * SABfx.depth1 / SABfx.operand4 + SABfx.tiR2 * SABfx.depth2 / SABfx.operand4, SABfx.tiG * SABfx.depth1 / SABfx.operand4 + SABfx.tiG2 * SABfx.depth2 / SABfx.operand4, SABfx.tiB * SABfx.depth1 / SABfx.operand4 + SABfx.tiB2 * SABfx.depth2 / SABfx.operand4));
                                        graphics.fillOval(SABfx.operand3 / 2 + SABfx.operand1 - SABfx.operand3 * operand25 / SABfx.operand4 / 2, SABfx.operand2 - operand25 / 4 + SABfx.operand4 / 4, SABfx.operand3 * operand25 / SABfx.operand4, operand25);
                                    }
                                }
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 11: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionDown[SABfx.operand1] = "";
                        SABfx.moreDn = 1;
                        while (SABfx.moreDn == 1) {
                            if (stringTokenizer.hasMoreTokens()) {
                                SABfx.chop = stringTokenizer.nextToken();
                            }
                            if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                SABfx.moreDn = 0;
                            }
                            if (SABfx.moreDn > 0) {
                                final String[] regionDown = SABfx.RegionDown;
                                final int operand26 = SABfx.operand1;
                                regionDown[operand26] = regionDown[operand26] + SABfx.chop + "+";
                            }
                        }
                        final String[] regionDown2 = SABfx.RegionDown;
                        final int operand27 = SABfx.operand1;
                        regionDown2[operand27] += "SB+";
                        break;
                    }
                    case 12: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionUp[SABfx.operand1] = "";
                        SABfx.moreUp = 1;
                        while (SABfx.moreUp == 1) {
                            if (stringTokenizer.hasMoreTokens()) {
                                SABfx.chop = stringTokenizer.nextToken();
                            }
                            if ("SB".equalsIgnoreCase(SABfx.chop)) {
                                SABfx.moreUp = 0;
                            }
                            if (SABfx.moreUp > 0) {
                                final String[] regionUp = SABfx.RegionUp;
                                final int operand28 = SABfx.operand1;
                                regionUp[operand28] = regionUp[operand28] + SABfx.chop + "+";
                            }
                        }
                        final String[] regionUp2 = SABfx.RegionUp;
                        final int operand29 = SABfx.operand1;
                        regionUp2[operand29] += "SB+";
                        break;
                    }
                    case 13: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionFlag[SABfx.operand1] = 0;
                        break;
                    }
                    case 14: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop);
                        SABfx.RegionFlag[SABfx.operand1] = 1;
                        break;
                    }
                    case 18: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop) % 101;
                        SABfx.Macro[SABfx.operand1] = "";
                        SABfx.moreUp = 1;
                        while (SABfx.moreUp == 1) {
                            if (stringTokenizer.hasMoreTokens()) {
                                SABfx.chop = stringTokenizer.nextToken();
                            }
                            if ("BS".equalsIgnoreCase(SABfx.chop)) {
                                SABfx.moreUp = 0;
                            }
                            if (SABfx.moreUp > 0) {
                                final String[] macro = SABfx.Macro;
                                final int operand30 = SABfx.operand1;
                                macro[operand30] = macro[operand30] + SABfx.chop + "+";
                            }
                        }
                        break;
                    }
                    case 19: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        SABfx.sabRdata += SABfx.Macro[SABfx.operand1];
                        SABfx.refresh = 1;
                        break;
                    }
                    case 39: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                SABfx.chop2 = "";
                                SABfx.chop3 = "";
                                SABfx.chop4 = "";
                                final StringTokenizer stringTokenizer2 = new StringTokenizer(SABfx.chop, " \t\n\r");
                                while (stringTokenizer2.hasMoreTokens()) {
                                    SABfx.chop2 = stringTokenizer2.nextToken();
                                    SABfx.chop4 = SABfx.chop3;
                                    SABfx.chop3 = SABfx.chop3 + SABfx.chop2 + " ";
                                    if (graphics3.getFontMetrics().stringWidth(SABfx.chop3) > SABfx.operand3) {
                                        graphics3.drawString(SABfx.chop4, SABfx.operand1, SABfx.operand2);
                                        SABfx.chop3 = SABfx.chop2 + " ";
                                        SABfx.operand2 += SABfx.vpt + SABfx.vspc;
                                    }
                                }
                                graphics3.drawString(SABfx.chop3, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                SABfx.chop2 = "";
                                SABfx.chop3 = "";
                                SABfx.chop4 = "";
                                final StringTokenizer stringTokenizer3 = new StringTokenizer(SABfx.chop, " \t\n\r");
                                while (stringTokenizer3.hasMoreTokens()) {
                                    SABfx.chop2 = stringTokenizer3.nextToken();
                                    SABfx.chop4 = SABfx.chop3;
                                    SABfx.chop3 = SABfx.chop3 + SABfx.chop2 + " ";
                                    if (graphics2.getFontMetrics().stringWidth(SABfx.chop3) > SABfx.operand3) {
                                        graphics2.drawString(SABfx.chop4, SABfx.operand1, SABfx.operand2);
                                        SABfx.chop3 = SABfx.chop2 + " ";
                                        SABfx.operand2 += SABfx.vpt + SABfx.vspc;
                                    }
                                }
                                graphics2.drawString(SABfx.chop3, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                SABfx.chop2 = "";
                                SABfx.chop3 = "";
                                SABfx.chop4 = "";
                                final StringTokenizer stringTokenizer4 = new StringTokenizer(SABfx.chop, " \t\n\r");
                                while (stringTokenizer4.hasMoreTokens()) {
                                    SABfx.chop2 = stringTokenizer4.nextToken();
                                    SABfx.chop4 = SABfx.chop3;
                                    SABfx.chop3 = SABfx.chop3 + SABfx.chop2 + " ";
                                    if (graphics.getFontMetrics().stringWidth(SABfx.chop3) > SABfx.operand3) {
                                        graphics.drawString(SABfx.chop4, SABfx.operand1, SABfx.operand2);
                                        SABfx.chop3 = SABfx.chop2 + " ";
                                        SABfx.operand2 += SABfx.vpt + SABfx.vspc;
                                    }
                                }
                                graphics.drawString(SABfx.chop3, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 40: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                SABfx.chop2 = "";
                                SABfx.chop3 = "";
                                SABfx.chop4 = "";
                                final StringTokenizer stringTokenizer5 = new StringTokenizer(SABfx.chop, " \t\n\r");
                                while (stringTokenizer5.hasMoreTokens()) {
                                    SABfx.chop2 = stringTokenizer5.nextToken();
                                    SABfx.chop4 = SABfx.chop3;
                                    SABfx.chop3 = SABfx.chop3 + SABfx.chop2 + " ";
                                    if (graphics3.getFontMetrics().stringWidth(SABfx.chop3) > SABfx.operand3) {
                                        SABfx.tx = (SABfx.operand3 - graphics3.getFontMetrics().stringWidth(SABfx.chop4)) / 2;
                                        graphics3.drawString(SABfx.chop4, SABfx.operand1 + SABfx.tx, SABfx.operand2);
                                        SABfx.chop3 = SABfx.chop2 + " ";
                                        SABfx.operand2 += SABfx.vpt + SABfx.vspc;
                                    }
                                }
                                SABfx.tx = (SABfx.operand3 - graphics3.getFontMetrics().stringWidth(SABfx.chop3)) / 2;
                                graphics3.drawString(SABfx.chop3, SABfx.operand1 + SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                SABfx.chop2 = "";
                                SABfx.chop3 = "";
                                SABfx.chop4 = "";
                                final StringTokenizer stringTokenizer6 = new StringTokenizer(SABfx.chop, " \t\n\r");
                                while (stringTokenizer6.hasMoreTokens()) {
                                    SABfx.chop2 = stringTokenizer6.nextToken();
                                    SABfx.chop4 = SABfx.chop3;
                                    SABfx.chop3 = SABfx.chop3 + SABfx.chop2 + " ";
                                    if (graphics2.getFontMetrics().stringWidth(SABfx.chop3) > SABfx.operand3) {
                                        SABfx.tx = (SABfx.operand3 - graphics2.getFontMetrics().stringWidth(SABfx.chop4)) / 2;
                                        graphics2.drawString(SABfx.chop4, SABfx.operand1 + SABfx.tx, SABfx.operand2);
                                        SABfx.chop3 = SABfx.chop2 + " ";
                                        SABfx.operand2 += SABfx.vpt + SABfx.vspc;
                                    }
                                }
                                SABfx.tx = (SABfx.operand3 - graphics2.getFontMetrics().stringWidth(SABfx.chop3)) / 2;
                                graphics2.drawString(SABfx.chop3, SABfx.operand1 + SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                SABfx.chop2 = "";
                                SABfx.chop3 = "";
                                SABfx.chop4 = "";
                                final StringTokenizer stringTokenizer7 = new StringTokenizer(SABfx.chop, " \t\n\r");
                                while (stringTokenizer7.hasMoreTokens()) {
                                    SABfx.chop2 = stringTokenizer7.nextToken();
                                    SABfx.chop4 = SABfx.chop3;
                                    SABfx.chop3 = SABfx.chop3 + SABfx.chop2 + " ";
                                    if (graphics.getFontMetrics().stringWidth(SABfx.chop3) > SABfx.operand3) {
                                        SABfx.tx = (SABfx.operand3 - graphics.getFontMetrics().stringWidth(SABfx.chop4)) / 2;
                                        graphics.drawString(SABfx.chop4, SABfx.operand1 + SABfx.tx, SABfx.operand2);
                                        SABfx.chop3 = SABfx.chop2 + " ";
                                        SABfx.operand2 += SABfx.vpt + SABfx.vspc;
                                    }
                                }
                                SABfx.tx = (SABfx.operand3 - graphics.getFontMetrics().stringWidth(SABfx.chop3)) / 2;
                                graphics.drawString(SABfx.chop3, SABfx.operand1 + SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 22: {
                        SABfx.rd = SABfx.tiR;
                        SABfx.gn = SABfx.tiG;
                        SABfx.bl = SABfx.tiB;
                        SABfx.br = 0;
                        SABfx.brnd = 0;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.br = this.getValue(SABfx.chop);
                        SABfx.br %= 128;
                        for (int n = -63; n < 64; ++n) {
                            int r = SABfx.rd + n * 2;
                            if (r > 255) {
                                r = 255;
                            }
                            if (r < 0) {
                                r = 0;
                            }
                            int g = SABfx.gn + n * 2;
                            if (g > 255) {
                                g = 255;
                            }
                            if (g < 0) {
                                g = 0;
                            }
                            int b = SABfx.bl + n * 2;
                            if (b > 255) {
                                b = 255;
                            }
                            if (b < 0) {
                                b = 0;
                            }
                            SABfx.clrs[n + 64] = new Color(r, g, b);
                        }
                        final Graphics graphics4 = SABfx.tile.getGraphics();
                        for (int n2 = 0; n2 < 100; ++n2) {
                            SABfx.brnd = (int) (Math.random() * SABfx.br);
                            if (SABfx.brnd < 0) {
                                SABfx.brnd = 0;
                            }
                            graphics4.setColor(SABfx.clrs[64 + SABfx.brnd - SABfx.br / 2]);
                            graphics4.fillRect(n2 % 10, n2 / 10, 1, 1);
                        }
                        for (int operand31 = SABfx.operand2; operand31 < SABfx.operand2 + SABfx.operand4; operand31 += 10) {
                            for (int operand32 = SABfx.operand1; operand32 < SABfx.operand1 + SABfx.operand3; operand32 += 10) {
                                switch (SABfx.plane) {
                                    case 0:
                                    case 1: {
                                        graphics3.drawImage(SABfx.tile, operand32, operand31, null);
                                        break;
                                    }
                                    case 2: {
                                        graphics2.drawImage(SABfx.tile, operand32, operand31, null);
                                        break;
                                    }
                                    case 3: {
                                        graphics.drawImage(SABfx.tile, operand32, operand31, null);
                                        break;
                                    }
                                }
                            }
                        }
                        graphics4.dispose();
                        break;
                    }
                    case 23: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.ti13 = this.getValue(SABfx.chop) % 101;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiW = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.tiH = this.getValue(SABfx.chop);
                        SABfx.Images[SABfx.ti13] = this.createImage(SABfx.tiW, SABfx.tiH);
                        graphics3.dispose();
                        graphics3 = SABfx.Images[SABfx.ti13].getGraphics();
                        break;
                    }
                    case 24: {
                        graphics.drawImage(SABfx.working, 0, 0, null);
                        break;
                    }
                    case 25: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (SABfx.operand2 == 0) {
                            SABfx.macTime[SABfx.operand1] = SABfx.operand2;
                        } else {
                            SABfx.macTime[SABfx.operand1] = SABfx.STCM + SABfx.operand2;
                        }
                        SABfx.macNumber[SABfx.operand1] = SABfx.operand3;
                        break;
                    }
                    case 26: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop) % 101;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        (SABfx.sfx[SABfx.operand1] = this.getAudioClip(this.getDocumentBase(), SABfx.chop)).start();
                        SABfx.sfx[SABfx.operand1].stop();
                        break;
                    }
                    case 27: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        SABfx.sfx[SABfx.operand1].start();
                        break;
                    }
                    case 28: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        SABfx.sfx[SABfx.operand1].loop(Clip.LOOP_CONTINUOUSLY);
                        break;
                    }
                    case 29: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        SABfx.sfx[SABfx.operand1].stop();
                        break;
                    }
                    case 30: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = 2 * this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        SABfx.tx = 0;
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                SABfx.tx = (SABfx.operand1 - graphics3.getFontMetrics().stringWidth(SABfx.chop)) / 2;
                                graphics3.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                SABfx.tx = (SABfx.operand1 - graphics2.getFontMetrics().stringWidth(SABfx.chop)) / 2;
                                graphics2.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                SABfx.tx = (SABfx.operand1 - graphics.getFontMetrics().stringWidth(SABfx.chop)) / 2;
                                graphics.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 31: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        --SABfx.operand3;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        --SABfx.operand4;
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.drawRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.drawRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.drawRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 47: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.runDrop = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int n3 = 0; n3 < SABfx.runDrop; ++n3) {
                                    graphics3.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4 + n3);
                                }
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int n4 = 0; n4 < SABfx.runDrop; ++n4) {
                                    graphics2.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4 + n4);
                                }
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int n5 = 0; n5 < SABfx.runDrop; ++n5) {
                                    graphics.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4 + n5);
                                }
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 46: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.runDrop = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int n6 = 0; n6 < SABfx.runDrop; ++n6) {
                                    graphics3.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3 + n6, SABfx.operand4);
                                }
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int n7 = 0; n7 < SABfx.runDrop; ++n7) {
                                    graphics2.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3 + n7, SABfx.operand4);
                                }
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int n8 = 0; n8 < SABfx.runDrop; ++n8) {
                                    graphics.drawLine(SABfx.operand1, SABfx.operand2, SABfx.operand3 + n8, SABfx.operand4);
                                }
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 4: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.fillRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.fillRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.fillRect(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 33: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        --SABfx.operand3;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        --SABfx.operand4;
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.drawOval(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.drawOval(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.drawOval(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 6: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.fillOval(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.fillOval(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.fillOval(SABfx.operand1, SABfx.operand2, SABfx.operand3, SABfx.operand4);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 35: {
                        String string = "";
                        String nextToken = "";
                        if (stringTokenizer.hasMoreTokens()) {
                            string = this.getString(stringTokenizer);
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        try {
                            System.out.println(string + nextToken);
                        } catch (final Exception ignored) {
                        }
                        break;
                    }
                    case 71: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        try {
                            final DataInputStream dataInputStream = new DataInputStream(new URL(this.getDocumentBase()).openStream());
                            SABfx.MYData = "";
                            String line;
                            while ((line = dataInputStream.readLine()) != null) {
                                SABfx.MYData = SABfx.MYData + line + "\n";
                            }
                            dataInputStream.close();
                        } catch (final Exception ignored) {
                        }
                        final StringTokenizer stringTokenizer8 = new StringTokenizer(SABfx.MYData, "+");
                        int n9 = 0;
                        while (stringTokenizer8.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer8);
                            while (SABfx.chop.length() > 1 && (SABfx.chop.charAt(0) == ' ' || SABfx.chop.charAt(0) == '\t' || SABfx.chop.charAt(0) == '\r' || SABfx.chop.charAt(0) == '\n')) {
                                SABfx.chop = SABfx.chop.substring(1);
                            }
                            SABfx.Array[n9] = SABfx.chop;
                            ++n9;
                        }
                        break;
                    }
                    case 72: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.myStr[SABfx.operand1] = SABfx.Array[SABfx.operand2];
                        break;
                    }
                    case 77: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.vspc = this.getValue(SABfx.chop);
                        break;
                    }
                    case 76: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand4 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.depth = this.getValue(SABfx.chop);
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int depth = SABfx.depth; depth < SABfx.operand3; depth += SABfx.depth) {
                                    graphics3.drawLine(SABfx.operand1 + depth, SABfx.operand2, SABfx.operand1 + depth, SABfx.operand2 + SABfx.operand4);
                                }
                                for (int depth2 = SABfx.depth; depth2 < SABfx.operand4; depth2 += SABfx.depth) {
                                    graphics3.drawLine(SABfx.operand1, SABfx.operand2 + depth2, SABfx.operand1 + SABfx.operand3, SABfx.operand2 + depth2);
                                }
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int depth3 = SABfx.depth; depth3 < SABfx.operand3; depth3 += SABfx.depth) {
                                    graphics2.drawLine(SABfx.operand1 + depth3, SABfx.operand2, SABfx.operand1 + depth3, SABfx.operand2 + SABfx.operand4);
                                }
                                for (int depth4 = SABfx.depth; depth4 < SABfx.operand4; depth4 += SABfx.depth) {
                                    graphics2.drawLine(SABfx.operand1, SABfx.operand2 + depth4, SABfx.operand1 + SABfx.operand3, SABfx.operand2 + depth4);
                                }
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                for (int depth5 = SABfx.depth; depth5 < SABfx.operand3; depth5 += SABfx.depth) {
                                    graphics.drawLine(SABfx.operand1 + depth5, SABfx.operand2, SABfx.operand1 + depth5, SABfx.operand2 + SABfx.operand4);
                                }
                                for (int depth6 = SABfx.depth; depth6 < SABfx.operand4; depth6 += SABfx.depth) {
                                    graphics.drawLine(SABfx.operand1, SABfx.operand2 + depth6, SABfx.operand1 + SABfx.operand3, SABfx.operand2 + depth6);
                                }
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 75: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.chop = SABfx.Array[SABfx.operand2];
                        SABfx.RegionFlag[SABfx.operand1] = this.getValue(SABfx.chop);
                        break;
                    }
                    case 74: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        final int n10 = SABfx.RegionFlag[SABfx.operand1];
                        SABfx.RegionFlag[SABfx.operand1] = SABfx.RegionFlag[SABfx.operand2];
                        SABfx.RegionFlag[SABfx.operand2] = n10;
                        break;
                    }
                    case 73: {
                        String nextToken2 = "";
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        final String spec = SABfx.myStr[SABfx.operand1];
                        if (stringTokenizer.hasMoreTokens()) {
                            nextToken2 = stringTokenizer.nextToken();
                        }
                        try {
                            //this.getAppletContext().showDocument(new URL(spec), nextToken2);
                            System.out.println(spec + nextToken2);
                        } catch (final Exception ignored) {
                        }
                        break;
                    }
                    case 36: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.chop += ".sbx";
                        SABfx.loadingScript = 1;
                        SABfx.noClick = 1;
                        SABfx.sabRdata = "";
                        SABfx.rdata = "";
                        this.init();
                        try {
                            final DataInputStream dataInputStream2 = new DataInputStream(new URL(this.getDocumentBase()).openStream());
                            SABfx.sabRdata = "";
                            String line2;
                            while ((line2 = dataInputStream2.readLine()) != null) {
                                SABfx.sabRdata += line2;
                            }
                            dataInputStream2.close();
                        } catch (final Exception ignored) {
                        }
                        SABfx.loadingScript = 0;
                        SABfx.refresh = 1;
                        SABfx.noClick = 1;
                        SABfx.rdata = "";
                        break;
                    }
                    case 42: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop) % 101;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop) % 16;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.vpt = this.getValue(SABfx.chop);
                        SABfx.ps[SABfx.operand1] = SABfx.vpt;
                        switch (SABfx.operand2 % 16) {
                            case 0: {
                                SABfx.myFont[SABfx.operand1] = new Font("Helvetica", Font.PLAIN, SABfx.vpt);
                                break;
                            }
                            case 1: {
                                SABfx.myFont[SABfx.operand1] = new Font("Helvetica", Font.BOLD, SABfx.vpt);
                                break;
                            }
                            case 2: {
                                SABfx.myFont[SABfx.operand1] = new Font("Helvetica", Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 3: {
                                SABfx.myFont[SABfx.operand1] = new Font("Helvetica", Font.BOLD + Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 4: {
                                SABfx.myFont[SABfx.operand1] = new Font("TimesRoman", Font.PLAIN, SABfx.vpt);
                                break;
                            }
                            case 5: {
                                SABfx.myFont[SABfx.operand1] = new Font("TimesRoman", Font.BOLD, SABfx.vpt);
                                break;
                            }
                            case 6: {
                                SABfx.myFont[SABfx.operand1] = new Font("TimesRoman", Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 7: {
                                SABfx.myFont[SABfx.operand1] = new Font("TimesRoman", Font.BOLD + Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 8: {
                                SABfx.myFont[SABfx.operand1] = new Font("Courier", Font.PLAIN, SABfx.vpt);
                                break;
                            }
                            case 9: {
                                SABfx.myFont[SABfx.operand1] = new Font("Courier", Font.BOLD, SABfx.vpt);
                                break;
                            }
                            case 10: {
                                SABfx.myFont[SABfx.operand1] = new Font("Courier", Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 11: {
                                SABfx.myFont[SABfx.operand1] = new Font("Courier", Font.BOLD + Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 12: {
                                SABfx.myFont[SABfx.operand1] = new Font("Dialog", Font.PLAIN, SABfx.vpt);
                                break;
                            }
                            case 13: {
                                SABfx.myFont[SABfx.operand1] = new Font("Dialog", Font.BOLD, SABfx.vpt);
                                break;
                            }
                            case 14: {
                                SABfx.myFont[SABfx.operand1] = new Font("Dialog", Font.ITALIC, SABfx.vpt);
                                break;
                            }
                            case 15: {
                                SABfx.myFont[SABfx.operand1] = new Font("Dialog", Font.BOLD + Font.ITALIC, SABfx.vpt);
                                break;
                            }
                        }
                        SABfx.f = SABfx.myFont[SABfx.operand1];
                        break;
                    }
                    case 37: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop) % 101;
                        SABfx.f = SABfx.myFont[SABfx.operand1];
                        SABfx.vpt = SABfx.ps[SABfx.operand1];
                        break;
                    }
                    case 41: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.syntax = Integer.parseInt(SABfx.chop);
                        if (SABfx.syntax > 0) {
                            SABfx.syntax += 11;
                            break;
                        }
                        break;
                    }
                    case 43: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = Integer.parseInt(SABfx.chop) % 101;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        SABfx.myStr[SABfx.operand1] = SABfx.chop;
                        break;
                    }
                    case 82: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop) % 101;
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop) % 101;
                        final String[] myStr = SABfx.myStr;
                        final int operand33 = SABfx.operand1;
                        myStr[operand33] += SABfx.myStr[SABfx.operand2];
                        break;
                    }
                    case 62: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop) % 101;
                        SABfx.myStr[SABfx.operand2] = Integer.toString(SABfx.operand1);
                        break;
                    }
                    case 84: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop) % 100;
                        SABfx.RegionFlag[SABfx.operand2] = Integer.parseInt(SABfx.myStr[SABfx.operand1]);
                        break;
                    }
                    case 85: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop) % 101;
                        SABfx.myStr[SABfx.operand1] = "";
                        for (int n11 = 0; n11 < 1000; ++n11) {
                            final String[] myStr2 = SABfx.myStr;
                            final int operand34 = SABfx.operand1;
                            myStr2[operand34] = myStr2[operand34] + SABfx.Array[n11] + "+";
                        }
                        break;
                    }
                    case 87: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop) % 101;
                        final StringTokenizer stringTokenizer9 = new StringTokenizer(SABfx.myStr[SABfx.operand1], "+");
                        int n12 = 0;
                        while (stringTokenizer9.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer9);
                            while (SABfx.chop.length() > 1 && (SABfx.chop.charAt(0) == ' ' ||
                                    SABfx.chop.charAt(0) == '\t' || SABfx.chop.charAt(0) == '\r' ||
                                    SABfx.chop.charAt(0) == '\n')) {
                                SABfx.chop = SABfx.chop.substring(1);
                            }
                            SABfx.Array[n12] = SABfx.chop;
                            ++n12;
                        }
                        break;
                    }
                    case 44: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = 2 * this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.chop = SABfx.myStr[SABfx.operand3];
                        SABfx.tx = 0;
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                SABfx.tx = (SABfx.operand1 - graphics3.getFontMetrics().stringWidth(SABfx.chop)) / 2;
                                graphics3.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                SABfx.tx = (SABfx.operand1 - graphics2.getFontMetrics().stringWidth(SABfx.chop)) / 2;
                                graphics2.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                SABfx.tx = (SABfx.operand1 - graphics.getFontMetrics().stringWidth(SABfx.chop)) / 2;
                                graphics.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 45: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.chop = SABfx.myStr[SABfx.operand3];
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                graphics3.drawString(SABfx.chop, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                graphics2.drawString(SABfx.chop, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                graphics.drawString(SABfx.chop, SABfx.operand1, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 69: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = this.getString(stringTokenizer);
                        }
                        SABfx.tx = 0;
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                SABfx.tx = SABfx.operand1 - graphics3.getFontMetrics().stringWidth(SABfx.chop);
                                graphics3.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                SABfx.tx = SABfx.operand1 - graphics2.getFontMetrics().stringWidth(SABfx.chop);
                                graphics2.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                SABfx.tx = SABfx.operand1 - graphics.getFontMetrics().stringWidth(SABfx.chop);
                                graphics.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                    case 70: {
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand3 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand1 = this.getValue(SABfx.chop);
                        if (stringTokenizer.hasMoreTokens()) {
                            SABfx.chop = stringTokenizer.nextToken();
                        }
                        SABfx.operand2 = this.getValue(SABfx.chop);
                        SABfx.chop = SABfx.myStr[SABfx.operand3];
                        SABfx.tx = 0;
                        switch (SABfx.plane) {
                            case 0:
                            case 1: {
                                graphics3.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics3.setFont(SABfx.f);
                                SABfx.tx = SABfx.operand1 - graphics3.getFontMetrics().stringWidth(SABfx.chop);
                                graphics3.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 2: {
                                graphics2.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics2.setFont(SABfx.f);
                                SABfx.tx = SABfx.operand1 - graphics2.getFontMetrics().stringWidth(SABfx.chop);
                                graphics2.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                            case 3: {
                                graphics.setColor(new Color(SABfx.tiR, SABfx.tiG, SABfx.tiB));
                                graphics.setFont(SABfx.f);
                                SABfx.tx = SABfx.operand1 - graphics.getFontMetrics().stringWidth(SABfx.chop);
                                graphics.drawString(SABfx.chop, SABfx.tx, SABfx.operand2);
                                break Label_17871;
                            }
                        }
                        break;
                    }
                }
            }
            SABfx.moreData = 0;
            if (stringTokenizer.hasMoreTokens()) {
                SABfx.moreData = 1;
            }
        }
        SABfx.rdata = "";
        graphics2.dispose();
        graphics.drawImage(SABfx.working, 0, 0, null);
        if (SABfx.loadingScript == 0 && SABfx.noClick == 1 && SABfx.rdata.isEmpty()) {
            SABfx.noClick = 0;
        }
        graphics3.dispose();
    }

    public void stop() {
        if (SABfx.aniThread != null && SABfx.aniThread.isAlive()) {
            if (SABfx.quiet != null) {
                SABfx.quiet.stop();
            }
            for (int i = 0; i < 100; ++i) {
                if (SABfx.sfx[i] != null) {
                    SABfx.sfx[i].stop();
                }
            }
            SABfx.aniThread.stop();
        }
        SABfx.aniThread = null;
    }

    public void start() {
        if (SABfx.aniThread == null) {
            (SABfx.aniThread = new Thread(this)).start();
            SABfx.loadingScript = 0;
            this.init();
        }
    }

    @Override
    public void run() {
        SABfx.macRdata = "";
        Label_0005_Outer:
        while (true) {
            while (true) {
                try {
                    while (true) {
                        ++SABfx.aniClock;
                        SABfx.STCM = System.currentTimeMillis();
                        if (SABfx.noClick == 0) {
                            for (int i = 0; i < 101; ++i) {
                                if (SABfx.macTime[SABfx.STCMP] > 0L && SABfx.macTime[SABfx.STCMP] < SABfx.STCM) {
                                    SABfx.macTime[SABfx.STCMP] = 0L;
                                    SABfx.macRdata += SABfx.Macro[SABfx.macNumber[SABfx.STCMP]];
                                }
                                ++SABfx.STCMP;
                                SABfx.STCMP %= 100;
                            }
                        }
                        if (SABfx.miceDown == 1) {
                            for (int j = 0; j < SABfx.myRegions; ++j) {
                                if (SABfx.RegionActive[j] > 0 && SABfx.miceX >= SABfx.RegionX[j] && SABfx.miceX <= SABfx.RegionX[j] + SABfx.RegionWidth[j] && SABfx.miceY >= SABfx.RegionY[j] && SABfx.miceY <= SABfx.RegionY[j] + SABfx.RegionHeight[j]) {
                                    if (SABfx.RegionDown[j] != null) {
                                        SABfx.macRdata += SABfx.RegionDown[j];
                                    }
                                    SABfx.refresh = 1;
                                    j = 999;
                                }
                                SABfx.miceDown = 0;
                            }
                        }
                        if (SABfx.miceUp == 1) {
                            for (int k = 0; k < SABfx.myRegions; ++k) {
                                if (SABfx.RegionActive[k] > 0 && SABfx.miceX >= SABfx.RegionX[k] && SABfx.miceX <= SABfx.RegionX[k] + SABfx.RegionWidth[k] && SABfx.miceY >= SABfx.RegionY[k] && SABfx.miceY <= SABfx.RegionY[k] + SABfx.RegionHeight[k]) {
                                    if (SABfx.RegionUp[k] != null) {
                                        SABfx.macRdata += SABfx.RegionUp[k];
                                    }
                                    SABfx.refresh = 1;
                                    k = 999;
                                }
                                SABfx.miceUp = 0;
                            }
                        }
                        for (int l = 0; l < SABfx.myRegions; ++l) {
                            if (SABfx.RegionInside[l] == 1 && ((SABfx.clickIt == 1 && SABfx.RegionActive[l] == 0) || SABfx.miceX < SABfx.RegionX[l] || SABfx.miceX > SABfx.RegionX[l] + SABfx.RegionWidth[l] || SABfx.miceY < SABfx.RegionY[l] || SABfx.miceY > SABfx.RegionY[l] + SABfx.RegionHeight[l])) {
                                SABfx.clickIt = 0;
                                SABfx.RegionInside[l] = 0;
                                if (SABfx.RegionExit[l] != null) {
                                    SABfx.macRdata += SABfx.RegionExit[l];
                                }
                                SABfx.refresh = 1;
                                l = 999;
                            }
                        }
                        for (int n = 0; n < SABfx.myRegions; ++n) {
                            if (SABfx.RegionInside[n] == 0 && SABfx.RegionActive[n] > 0 && SABfx.miceX >= SABfx.RegionX[n] && SABfx.miceX <= SABfx.RegionX[n] + SABfx.RegionWidth[n] && SABfx.miceY >= SABfx.RegionY[n] && SABfx.miceY <= SABfx.RegionY[n] + SABfx.RegionHeight[n]) {
                                SABfx.clickIt = 1;
                                if (SABfx.RegionEnter[n] != null) {
                                    SABfx.macRdata += SABfx.RegionEnter[n];
                                }
                                SABfx.RegionInside[n] = 1;
                                SABfx.refresh = 1;
                                n = 999;
                            }
                        }
                        final Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(System.currentTimeMillis());
                        SABfx.RegionFlag[102] = calendar.get(Calendar.YEAR);
                        SABfx.RegionFlag[103] = calendar.get(Calendar.MONTH) + 1; // Months start from 0
                        SABfx.RegionFlag[104] = calendar.get(Calendar.DAY_OF_MONTH);
                        SABfx.RegionFlag[105] = calendar.get(Calendar.DAY_OF_WEEK); // Day of week
                        SABfx.RegionFlag[106] = calendar.get(Calendar.HOUR_OF_DAY); // 24-hour format
                        SABfx.RegionFlag[107] = calendar.get(Calendar.MINUTE);
                        SABfx.RegionFlag[108] = calendar.get(Calendar.SECOND);
                        if (SABfx.clickIt == 2) {
                            SABfx.cursor = 3;
                        }
                        if (SABfx.clickIt == 1) {
                            SABfx.cursor = 12;
                        }
                        if (SABfx.clickIt == 0) {
                            SABfx.cursor = 0;
                        }
                        SABfx.frame.setCursor(SABfx.cursor);
                        if (SABfx.sabRdata.isEmpty()) {
                            SABfx.refresh = 0;
                        }
                        if (!SABfx.sabRdata.isEmpty() || !SABfx.macRdata.isEmpty()) {
                            SABfx.refresh = 1;
                        }
                        if (SABfx.refresh == 1) {
                            this.repaint();
                        }
                        Thread.sleep(25L);
                        if (SABfx.refresh == 0 && SABfx.clickIt == 2) {
                            SABfx.loadingScript = 0;
                            SABfx.clickIt = 0;
                        }
                    }
                } catch (final Exception ex) {
                    continue Label_0005_Outer;
                }
                //continue;
            }
        }
    }

    @Override
    public synchronized boolean mouseDown(final Event event, final int miceX, final int miceY) {
        if (SABfx.noClick == 0 && SABfx.loadingScript == 0) {
            SABfx.miceDown = 1;
            SABfx.miceX = miceX;
            SABfx.miceY = miceY;
        }
        return true;
    }

    @Override
    public synchronized boolean mouseUp(final Event event, final int miceX, final int miceY) {
        if (SABfx.noClick == 0 && SABfx.loadingScript == 0) {
            SABfx.miceUp = 1;
            SABfx.miceX = miceX;
            SABfx.miceY = miceY;
        }
        return true;
    }

    @Override
    public synchronized boolean mouseMove(final Event event, final int miceX, final int miceY) {
        if (SABfx.noClick == 0 && SABfx.loadingScript == 0) {
            SABfx.miceDrag = 0;
            SABfx.miceMove = 1;
            SABfx.miceX = miceX;
            SABfx.miceY = miceY;
        }
        return true;
    }

    @Override
    public synchronized boolean mouseDrag(final Event event, final int miceX, final int miceY) {
        if (SABfx.noClick == 0 && SABfx.loadingScript == 0) {
            SABfx.miceX = miceX;
            SABfx.miceY = miceY;
        }
        return true;
    }
}
