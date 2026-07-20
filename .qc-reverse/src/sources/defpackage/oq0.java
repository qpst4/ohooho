package defpackage;

import android.content.SharedPreferences;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'z' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oq0 {
    public static final oq0 A;
    public static final oq0 A0;
    public static final oq0 B;
    public static final oq0 B0;
    public static final oq0 C;
    public static final oq0 C0;
    public static final oq0 D;
    public static final oq0 D0;
    public static final oq0 E;
    public static final oq0 E0;
    public static final oq0 F;
    public static final oq0 F0;
    public static final oq0 G;
    public static final oq0 G0;
    public static final oq0 H;
    public static final oq0 H0;
    public static final oq0 I;
    public static final oq0 I0;
    public static final oq0 J;
    public static final oq0 J0;
    public static final oq0 K;
    public static final oq0 K0;
    public static final oq0 L;
    public static final oq0 L0;
    public static final oq0 M;
    public static final oq0 M0;
    public static final oq0 N;
    public static final oq0 N0;
    public static final oq0 O;
    public static final oq0 O0;
    public static final oq0 P;
    public static final oq0 P0;
    public static final oq0 Q;
    public static final oq0 Q0;
    public static final oq0 R;
    public static final oq0 R0;
    public static final oq0 S;
    public static final oq0 S0;
    public static final oq0 T;
    public static final oq0 T0;
    public static final oq0 U;
    public static final oq0 U0;
    public static final oq0 V;
    public static final oq0 V0;
    public static final oq0 W;
    public static final oq0 W0;
    public static final oq0 X;
    public static final oq0 X0;
    public static final oq0 Y;
    public static final oq0 Y0;
    public static final oq0 Z;
    public static final oq0 Z0;
    public static final oq0 a0;
    public static final oq0 a1;
    public static final oq0 b0;
    public static final oq0 b1;
    public static final oq0 c0;
    public static final oq0 c1;
    public static final oq0 d;
    public static final oq0 d0;
    public static final oq0 d1;
    public static final oq0 e;
    public static final oq0 e0;
    public static final oq0 e1;
    public static final oq0 f;
    public static final oq0 f0;
    public static final oq0 f1;
    public static final oq0 g;
    public static final oq0 g0;
    public static final List g1;
    public static final oq0 h;
    public static final oq0 h0;
    public static final List h1;
    public static final oq0 i;
    public static final oq0 i0;
    public static final List i1;
    public static final oq0 j;
    public static final oq0 j0;
    public static final List j1;
    public static final oq0 k;
    public static final oq0 k0;
    public static final List k1;
    public static final oq0 l;
    public static final oq0 l0;
    public static final List l1;
    public static final oq0 m;
    public static final oq0 m0;
    public static final /* synthetic */ oq0[] m1;
    public static final oq0 n;
    public static final oq0 n0;
    public static final oq0 o;
    public static final oq0 o0;
    public static final oq0 p;
    public static final oq0 p0;
    public static final oq0 q;
    public static final oq0 q0;
    public static final oq0 r;
    public static final oq0 r0;
    public static final oq0 s;
    public static final oq0 s0;
    public static final oq0 t;
    public static final oq0 t0;
    public static final oq0 u;
    public static final oq0 u0;
    public static final oq0 v;
    public static final oq0 v0;
    public static final oq0 w;
    public static final oq0 w0;
    public static final oq0 x;
    public static final oq0 x0;
    public static final oq0 y;
    public static final oq0 y0;
    public static final oq0 z;
    public static final oq0 z0;
    public final Object b;
    public final Object c;

    static {
        oq0 oq0Var = new oq0("versionCode", 0, -1);
        d = oq0Var;
        oq0 oq0Var2 = new oq0("debugVisual", 1, Boolean.valueOf(dn.D));
        e = oq0Var2;
        oq0 oq0Var3 = new oq0("debugLogs", 2, Boolean.valueOf(dn.E));
        f = oq0Var3;
        oq0 oq0Var4 = new oq0("debugLogsContent", 3, dn.S);
        g = oq0Var4;
        oq0 oq0Var5 = new oq0("systemGestureOverlap", 4, Boolean.valueOf(dn.F));
        h = oq0Var5;
        oq0 oq0Var6 = new oq0("changelogPopupShown", 5, Boolean.TRUE);
        i = oq0Var6;
        oq0 oq0Var7 = new oq0("firstUseTutorialDone", 6, Boolean.FALSE);
        j = oq0Var7;
        oq0 oq0Var8 = new oq0("dispatchBugPopup", 7, Boolean.valueOf(dn.C));
        k = oq0Var8;
        oq0 oq0Var9 = new oq0("autoTapMode", 8, dn.W);
        l = oq0Var9;
        oq0 oq0Var10 = new oq0("keyboardTriggersHandle", 9, dn.X);
        m = oq0Var10;
        oq0 oq0Var11 = new oq0("keyboardTrackerHandle", 10, dn.Y);
        n = oq0Var11;
        oq0 oq0Var12 = new oq0("keyboardAboveExtra", 11, Integer.valueOf(dn.w0));
        o = oq0Var12;
        oq0 oq0Var13 = new oq0("keyboardThinnerPercentage", 12, Integer.valueOf(dn.x0));
        p = oq0Var13;
        oq0 oq0Var14 = new oq0("cursorDesign", 13, dn.U);
        q = oq0Var14;
        oq0 oq0Var15 = new oq0("cursorSize", 14, Float.valueOf(dn.s0));
        r = oq0Var15;
        oq0 oq0Var16 = new oq0("cursorTipSize", 15, Float.valueOf(dn.u0));
        s = oq0Var16;
        oq0 oq0Var17 = new oq0("cursorMirrored", 16, Boolean.valueOf(dn.v0));
        t = oq0Var17;
        oq0 oq0Var18 = new oq0("cursorDesign1StrokeSize", 17, Float.valueOf(dn.t0));
        u = oq0Var18;
        oq0 oq0Var19 = new oq0("cursorDesign1StrokeColor", 18, Integer.valueOf(dn.Z));
        v = oq0Var19;
        oq0 oq0Var20 = new oq0("cursorDesign1FillColor", 19, Integer.valueOf(dn.a0));
        w = oq0Var20;
        oq0 oq0Var21 = new oq0("cursorDesign1DotColor", 20, Integer.valueOf(dn.b0));
        x = oq0Var21;
        oq0 oq0Var22 = new oq0("cursorDesignCustomBitmap", 21, "");
        y = oq0Var22;
        Float fValueOf = Float.valueOf(0.5f);
        oq0 oq0Var23 = new oq0("cursorDesignCustomTipX", 22, fValueOf);
        z = oq0Var23;
        oq0 oq0Var24 = new oq0("cursorDesignCustomTipY", 23, fValueOf);
        A = oq0Var24;
        oq0 oq0Var25 = new oq0("trackerDesign", 24, dn.V);
        B = oq0Var25;
        oq0 oq0Var26 = new oq0("trackerDesignCustomBitmap", 25, "");
        C = oq0Var26;
        oq0 oq0Var27 = new oq0("trackerSize", 26, Float.valueOf(dn.y0));
        D = oq0Var27;
        oq0 oq0Var28 = new oq0("trackerInsideColor", 27, Integer.valueOf(dn.f0));
        E = oq0Var28;
        oq0 oq0Var29 = new oq0("trackerOutsideColor", 28, Integer.valueOf(dn.g0));
        F = oq0Var29;
        oq0 oq0Var30 = new oq0("trackerOpacity", 29, Integer.valueOf(dn.h0));
        G = oq0Var30;
        oq0 oq0Var31 = new oq0("trackerDesignGradientRadius", 30, Integer.valueOf(dn.z0));
        H = oq0Var31;
        oq0 oq0Var32 = new oq0("trackerDesignSquircleRadius", 31, Integer.valueOf(dn.A0));
        I = oq0Var32;
        oq0 oq0Var33 = new oq0("trackerDesignRoundedRectangleRadius", 32, Integer.valueOf(dn.B0));
        J = oq0Var33;
        oq0 oq0Var34 = new oq0("trackerDesignColor", 33, Integer.valueOf(dn.e0));
        K = oq0Var34;
        oq0 oq0Var35 = new oq0("autoTapDelay", 34, Integer.valueOf(dn.u));
        L = oq0Var35;
        oq0 oq0Var36 = new oq0("clickDistanceThreshold", 35, Float.valueOf(dn.v));
        M = oq0Var36;
        oq0 oq0Var37 = new oq0("hideOnOutsideActionEnabled", 36, Boolean.valueOf(dn.m));
        N = oq0Var37;
        oq0 oq0Var38 = new oq0("hideOnFlingEnabled", 37, Boolean.valueOf(dn.n));
        O = oq0Var38;
        oq0 oq0Var39 = new oq0("hideTimeoutEnabled", 38, Boolean.valueOf(dn.o));
        P = oq0Var39;
        oq0 oq0Var40 = new oq0("hideTimeoutThreshold", 39, Integer.valueOf(dn.q));
        Q = oq0Var40;
        oq0 oq0Var41 = new oq0("vibrationDuration", 40, Integer.valueOf(dn.r));
        R = oq0Var41;
        oq0 oq0Var42 = new oq0("rippleDuration", 41, Integer.valueOf(dn.t));
        S = oq0Var42;
        oq0 oq0Var43 = new oq0("rippleSize", 42, Float.valueOf(dn.h1));
        T = oq0Var43;
        oq0 oq0Var44 = new oq0("vibrationOnClick", 43, Boolean.valueOf(dn.y));
        U = oq0Var44;
        oq0 oq0Var45 = new oq0("rippleOnClick", 44, Boolean.valueOf(dn.A));
        V = oq0Var45;
        oq0 oq0Var46 = new oq0("rippleClickColor", 45, Integer.valueOf(dn.n0));
        W = oq0Var46;
        oq0 oq0Var47 = new oq0("vibrationOnCursorAction", 46, Boolean.valueOf(dn.z));
        X = oq0Var47;
        oq0 oq0Var48 = new oq0("rippleOnCursorAction", 47, Boolean.valueOf(dn.B));
        Y = oq0Var48;
        oq0 oq0Var49 = new oq0("rippleCursorActionColor", 48, Integer.valueOf(dn.o0));
        Z = oq0Var49;
        oq0 oq0Var50 = new oq0("vibrationOnTriggerStart", 49, Boolean.valueOf(dn.x));
        a0 = oq0Var50;
        oq0 oq0Var51 = new oq0("trailType", 50, dn.T);
        b0 = oq0Var51;
        oq0 oq0Var52 = new oq0("trailColor", 51, Integer.valueOf(dn.c0));
        c0 = oq0Var52;
        oq0 oq0Var53 = new oq0("trailLifespan", 52, Integer.valueOf(dn.w));
        d0 = oq0Var53;
        oq0 oq0Var54 = new oq0("gestureRecorderColor", 53, Integer.valueOf(dn.d0));
        e0 = oq0Var54;
        oq0 oq0Var55 = new oq0("gestureRecorderEdgeCancel", 54, Boolean.valueOf(dn.G));
        f0 = oq0Var55;
        oq0 oq0Var56 = new oq0("appFilterMode", 55, dn.E1);
        g0 = oq0Var56;
        oq0 oq0Var57 = new oq0("appFilterList", 56, dn.F1);
        h0 = oq0Var57;
        oq0 oq0Var58 = new oq0("screenWidth", 57, -1);
        i0 = oq0Var58;
        oq0 oq0Var59 = new oq0("screenHeight", 58, -1);
        j0 = oq0Var59;
        oq0 oq0Var60 = new oq0("edgeActionsThreshold", 59, Float.valueOf(dn.Q));
        k0 = oq0Var60;
        oq0 oq0Var61 = new oq0("edgeActionsDelay", 60, Integer.valueOf(dn.R));
        l0 = oq0Var61;
        oq0 oq0Var62 = new oq0("edgeActionsVisualFeedback", 61, Boolean.valueOf(dn.H));
        m0 = oq0Var62;
        oq0 oq0Var63 = new oq0("edgeActionsVibrationFeedback", 62, Boolean.valueOf(dn.I));
        n0 = oq0Var63;
        oq0 oq0Var64 = new oq0("edgeActionsPreviewIcon", 63, Boolean.valueOf(dn.J));
        o0 = oq0Var64;
        oq0 oq0Var65 = new oq0("edgeActionsPreviewSensitivity", 64, Integer.valueOf(dn.K));
        p0 = oq0Var65;
        oq0 oq0Var66 = new oq0("edgeActionsPreviewSize", 65, Integer.valueOf(dn.L));
        q0 = oq0Var66;
        oq0 oq0Var67 = new oq0("edgeActionsVisualColor", 66, Integer.valueOf(dn.M));
        r0 = oq0Var67;
        oq0 oq0Var68 = new oq0("edgeActionsVisualSize", 67, Float.valueOf(dn.N));
        s0 = oq0Var68;
        oq0 oq0Var69 = new oq0("edgeActionsVisualOpacity", 68, Integer.valueOf(dn.O));
        t0 = oq0Var69;
        oq0 oq0Var70 = new oq0("edgeActionsTriggerMode", 69, dn.P);
        u0 = oq0Var70;
        oq0 oq0Var71 = new oq0("trackerActionsInsideSize", 70, Float.valueOf(dn.D0));
        v0 = oq0Var71;
        oq0 oq0Var72 = new oq0("trackerActionsInsideColor", 71, Integer.valueOf(dn.J0));
        w0 = oq0Var72;
        oq0 oq0Var73 = new oq0("trackerActionsOutsideSize", 72, Float.valueOf(dn.E0));
        x0 = oq0Var73;
        oq0 oq0Var74 = new oq0("trackerActionsOutsideColor", 73, Integer.valueOf(dn.K0));
        y0 = oq0Var74;
        oq0 oq0Var75 = new oq0("trackerActionsStrokeSize", 74, Float.valueOf(dn.F0));
        z0 = oq0Var75;
        oq0 oq0Var76 = new oq0("trackerActionsStrokeColor", 75, Integer.valueOf(dn.L0));
        A0 = oq0Var76;
        oq0 oq0Var77 = new oq0("trackerActionsIconSize", 76, Integer.valueOf(dn.G0));
        B0 = oq0Var77;
        oq0 oq0Var78 = new oq0("trackerActionsIconColor", 77, Integer.valueOf(dn.M0));
        C0 = oq0Var78;
        oq0 oq0Var79 = new oq0("trackerActionsAutoSweepOffset", 78, Boolean.valueOf(dn.X0));
        D0 = oq0Var79;
        oq0 oq0Var80 = new oq0("trackerActionsSweepOffset", 79, Float.valueOf(dn.Z0));
        E0 = oq0Var80;
        oq0 oq0Var81 = new oq0("trackerActionsTriggerMode", 80, dn.a1);
        F0 = oq0Var81;
        oq0 oq0Var82 = new oq0("trackerActionsVibrationFeedback", 81, Boolean.valueOf(dn.Y0));
        G0 = oq0Var82;
        int i2 = dn.b1;
        oq0 oq0Var83 = new oq0("trackerActionsTriggerDelay", 82, Integer.valueOf(i2));
        H0 = oq0Var83;
        oq0 oq0Var84 = new oq0("trackerActionsCenterActionIcon", 83, Boolean.valueOf(dn.c1));
        I0 = oq0Var84;
        oq0 oq0Var85 = new oq0("trackerActionsCenterActionTriggerMode", 84, dn.d1);
        J0 = oq0Var85;
        oq0 oq0Var86 = new oq0("trackerActionsCenterActionTriggerDelay", 85, Integer.valueOf(i2));
        K0 = oq0Var86;
        oq0 oq0Var87 = new oq0("trackerActionsAlwaysVisible", 86, Boolean.valueOf(dn.W0));
        L0 = oq0Var87;
        oq0 oq0Var88 = new oq0("limitedMode", 87, Boolean.valueOf(dn.G1));
        M0 = oq0Var88;
        oq0 oq0Var89 = new oq0(dn.H1, dn.I1);
        N0 = oq0Var89;
        oq0 oq0Var90 = new oq0("longTapTrackerThreshold", 89, Integer.valueOf(dn.J1));
        O0 = oq0Var90;
        oq0 oq0Var91 = new oq0("doubleTapTrackerAction", 90, dn.L1);
        P0 = oq0Var91;
        oq0 oq0Var92 = new oq0("doubleTapTrackerThreshold", 91, Integer.valueOf(dn.M1));
        Q0 = oq0Var92;
        oq0 oq0Var93 = new oq0("secondTapTrackerAction", 92, dn.N1);
        R0 = oq0Var93;
        oq0 oq0Var94 = new oq0("materialYouColoring", 93, Boolean.valueOf(dn.P1));
        S0 = oq0Var94;
        oq0 oq0Var95 = new oq0("materialYouLastColor", 94, 16777215);
        T0 = oq0Var95;
        oq0 oq0Var96 = new oq0("cursorHideOnTrackerRelease", 95, Boolean.valueOf(dn.p));
        U0 = oq0Var96;
        oq0 oq0Var97 = new oq0("deviceMinBrightness", 96, -2);
        V0 = oq0Var97;
        oq0 oq0Var98 = new oq0("deviceMaxBrightness", 97, -2);
        W0 = oq0Var98;
        oq0 oq0Var99 = new oq0("enabledOnLockscreen", 98, Boolean.valueOf(dn.R1));
        X0 = oq0Var99;
        oq0 oq0Var100 = new oq0("vibrationAmplitude", 99, Integer.valueOf(dn.s));
        Y0 = oq0Var100;
        oq0 oq0Var101 = new oq0("appStopped", 100, Boolean.valueOf(dn.S1));
        Z0 = oq0Var101;
        oq0 oq0Var102 = new oq0("disabledWhileSPenDetached", 101, Boolean.valueOf(dn.Q1));
        a1 = oq0Var102;
        oq0 oq0Var103 = new oq0("iconPackName", 102, dn.B2);
        b1 = oq0Var103;
        oq0 oq0Var104 = new oq0("inputDispatcherBugOnDetected", 103, Boolean.valueOf(dn.Q2));
        c1 = oq0Var104;
        oq0 oq0Var105 = new oq0("inputDispatcherBugOnTrackerRelease", 104, Boolean.valueOf(dn.R2));
        d1 = oq0Var105;
        oq0 oq0Var106 = new oq0("inputDispatcherBugOnTrackerLongTap", 105, Boolean.valueOf(dn.S2));
        e1 = oq0Var106;
        oq0 oq0Var107 = new oq0("timedDisableTimestamp", 106, 0L);
        f1 = oq0Var107;
        m1 = new oq0[]{oq0Var, oq0Var2, oq0Var3, oq0Var4, oq0Var5, oq0Var6, oq0Var7, oq0Var8, oq0Var9, oq0Var10, oq0Var11, oq0Var12, oq0Var13, oq0Var14, oq0Var15, oq0Var16, oq0Var17, oq0Var18, oq0Var19, oq0Var20, oq0Var21, oq0Var22, oq0Var23, oq0Var24, oq0Var25, oq0Var26, oq0Var27, oq0Var28, oq0Var29, oq0Var30, oq0Var31, oq0Var32, oq0Var33, oq0Var34, oq0Var35, oq0Var36, oq0Var37, oq0Var38, oq0Var39, oq0Var40, oq0Var41, oq0Var42, oq0Var43, oq0Var44, oq0Var45, oq0Var46, oq0Var47, oq0Var48, oq0Var49, oq0Var50, oq0Var51, oq0Var52, oq0Var53, oq0Var54, oq0Var55, oq0Var56, oq0Var57, oq0Var58, oq0Var59, oq0Var60, oq0Var61, oq0Var62, oq0Var63, oq0Var64, oq0Var65, oq0Var66, oq0Var67, oq0Var68, oq0Var69, oq0Var70, oq0Var71, oq0Var72, oq0Var73, oq0Var74, oq0Var75, oq0Var76, oq0Var77, oq0Var78, oq0Var79, oq0Var80, oq0Var81, oq0Var82, oq0Var83, oq0Var84, oq0Var85, oq0Var86, oq0Var87, oq0Var88, oq0Var89, oq0Var90, oq0Var91, oq0Var92, oq0Var93, oq0Var94, oq0Var95, oq0Var96, oq0Var97, oq0Var98, oq0Var99, oq0Var100, oq0Var101, oq0Var102, oq0Var103, oq0Var104, oq0Var105, oq0Var106, oq0Var107};
        List listAsList = Arrays.asList(oq0Var15, oq0Var16, oq0Var18, oq0Var27, oq0Var36, oq0Var43, oq0Var60, oq0Var68, oq0Var71, oq0Var73, oq0Var75);
        g1 = listAsList;
        List listAsList2 = Arrays.asList(oq0Var23, oq0Var24, oq0Var80);
        List listAsList3 = Arrays.asList(oq0Var107);
        h1 = Arrays.asList(oq0Var97, oq0Var98);
        i1 = Arrays.asList("cursorStrokeSize");
        j1 = (List) listAsList.stream().map(new u2(3)).collect(Collectors.toList());
        k1 = (List) listAsList2.stream().map(new u2(3)).collect(Collectors.toList());
        l1 = (List) listAsList3.stream().map(new u2(3)).collect(Collectors.toList());
    }

    public oq0(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    public static boolean a(SharedPreferences sharedPreferences, oq0 oq0Var) {
        return sharedPreferences.getBoolean(oq0Var.name(), ((Boolean) oq0Var.b).booleanValue());
    }

    public static float b(SharedPreferences sharedPreferences, oq0 oq0Var) {
        return sharedPreferences.getFloat(oq0Var.name(), ((Float) oq0Var.b).floatValue());
    }

    public static int c(SharedPreferences sharedPreferences, oq0 oq0Var) {
        return sharedPreferences.getInt(oq0Var.name(), ((Integer) oq0Var.b).intValue());
    }

    public static String d(SharedPreferences sharedPreferences, oq0 oq0Var) {
        return sharedPreferences.getString(oq0Var.name(), (String) oq0Var.b);
    }

    public static void e(SharedPreferences.Editor editor, oq0 oq0Var) {
        editor.putBoolean(oq0Var.name(), ((Boolean) oq0Var.b).booleanValue());
    }

    public static void f(SharedPreferences.Editor editor, oq0 oq0Var) {
        editor.putFloat(oq0Var.name(), ((Float) oq0Var.b).floatValue());
    }

    public static void g(SharedPreferences.Editor editor, oq0 oq0Var) {
        editor.putInt(oq0Var.name(), ((Integer) oq0Var.b).intValue());
    }

    public static void h(SharedPreferences.Editor editor, oq0 oq0Var) {
        editor.putString(oq0Var.name(), (String) oq0Var.b);
    }

    public static void i(SharedPreferences.Editor editor, oq0 oq0Var) {
        editor.putBoolean(oq0Var.name(), ((Boolean) oq0Var.c).booleanValue());
    }

    public static void j(SharedPreferences.Editor editor, oq0 oq0Var) {
        editor.putInt(oq0Var.name(), ((Integer) oq0Var.c).intValue());
    }

    public static oq0 valueOf(String str) {
        return (oq0) Enum.valueOf(oq0.class, str);
    }

    public static oq0[] values() {
        return (oq0[]) m1.clone();
    }

    public oq0(String str, int i2, Object obj) {
        this.b = obj;
        this.c = obj;
    }
}
