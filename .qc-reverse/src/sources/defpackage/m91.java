package defpackage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m91 {
    private static final i70 gson = new i70();
    private o91 actionIconDesign;
    private boolean actionVibration;
    private i3 defaultTrigger;
    private int defaultTriggerDelay;
    private List<h91> longActions;
    private int longSwipeSize;
    private h91 longTapAction;
    private int shortSwipeSize;
    private int swipeThreshold;
    private h91 tapAction;
    private List<h91> shortActions = new ArrayList();
    private l91 mode = l91.off;
    private k91 design = k91.pie;
    private q91 pieDesign = new q91();

    public m91() {
        this.longActions = new ArrayList();
        o91 o91Var = new o91();
        o91Var.f();
        this.actionIconDesign = o91Var;
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        A();
        ArrayList arrayList = new ArrayList();
        this.longActions = arrayList;
        n3 n3Var = n3.expandQuickSettings;
        wa waVar = j00.k;
        i3 i3Var = i3.empty;
        arrayList.add(new h91(1, n3Var, waVar, i3Var));
        this.longActions.add(new h91(2, n3.grabCursor, null, i3.instant));
        this.longActions.add(new h91(1, n3.expandNotifications, waVar, i3Var));
    }

    public static m91 a(m91 m91Var, float f) {
        m91 m91Var2 = new m91();
        m91Var2.mode = m91Var.mode;
        m91Var2.design = m91Var.design;
        m91Var2.tapAction = m91Var.tapAction;
        m91Var2.longTapAction = m91Var.longTapAction;
        i70 i70Var = gson;
        String strI = i70Var.i(m91Var.shortActions);
        Type type = h91.LIST_HASH_TYPE;
        m91Var2.shortActions = (List) i70Var.f(strI, type);
        m91Var2.longActions = (List) i70Var.e(i70Var.i(m91Var.longActions), new mc1(type));
        m91Var2.swipeThreshold = (int) (m91Var.swipeThreshold * f);
        m91Var2.shortSwipeSize = (int) (m91Var.shortSwipeSize * f);
        m91Var2.longSwipeSize = (int) (m91Var.longSwipeSize * f);
        m91Var2.actionVibration = m91Var.actionVibration;
        m91Var2.defaultTrigger = m91Var.defaultTrigger;
        m91Var2.defaultTriggerDelay = m91Var.defaultTriggerDelay;
        m91Var2.pieDesign = q91.a(m91Var.pieDesign, f);
        return m91Var2;
    }

    public final void A() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(60);
        this.longSwipeSize = ey0.a(60);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        this.longTapAction = new h91(1, n3.recentsButton, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        arrayList.add(new h91(1, n3.homeButton, null, i3Var));
        this.shortActions.add(new h91(2, n3.grabCursor, null, i3.instant));
        this.shortActions.add(new h91(1, n3.backButton, null, i3Var));
    }

    public final void B() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(60);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        this.longTapAction = new h91(1, n3.recentsButton, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        n3 n3Var2 = n3.expandQuickSettings;
        wa waVar = j00.k;
        arrayList.add(new h91(1, n3Var2, waVar, i3Var));
        this.shortActions.add(new h91(1, n3.homeButton, null, i3Var));
        this.shortActions.add(new h91(2, n3.grabCursor, null, i3.instant));
        this.shortActions.add(new h91(1, n3.backButton, null, i3Var));
        this.shortActions.add(new h91(1, n3.expandNotifications, waVar, i3Var));
    }

    public final void C() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(60);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        n3 n3Var3 = n3.expandQuickSettings;
        wa waVar = j00.k;
        arrayList.add(new h91(1, n3Var3, waVar, i3Var));
        this.shortActions.add(new h91(2, n3Var2, null, i3.instant));
        this.shortActions.add(new h91(1, n3.expandNotifications, waVar, i3Var));
    }

    public final void D() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(60);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        arrayList.add(new h91(1, n3.toggleFlashlight, null, i3Var));
        this.shortActions.add(new h91(1, n3.launchCamera, null, i3Var));
        this.shortActions.add(new h91(2, n3Var2, null, i3.instant));
        this.shortActions.add(new h91(1, n3.lockScreen, null, i3Var));
        this.shortActions.add(new h91(1, n3.takeScreenshot, null, i3Var));
    }

    public final void E() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(60);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        arrayList.add(new h91(1, n3.openAppDrawer, null, i3Var));
        this.shortActions.add(new h91(1, n3.openVolumeControl, null, i3Var));
        this.shortActions.add(new h91(2, n3Var2, null, i3.instant));
        this.shortActions.add(new h91(1, n3.takeScreenshot, null, i3Var));
        this.shortActions.add(new h91(1, n3.switchToPrevApp, null, i3Var));
    }

    public final void F(boolean z) {
        this.actionVibration = z;
    }

    public final void G(i3 i3Var) {
        this.defaultTrigger = i3Var;
    }

    public final void H(int i) {
        this.defaultTriggerDelay = i;
    }

    public final void I(k91 k91Var) {
        this.design = k91Var;
    }

    public final void J(int i) {
        this.longSwipeSize = i;
    }

    public final void K(h91 h91Var) {
        this.longTapAction = h91Var;
    }

    public final void L(l91 l91Var) {
        this.mode = l91Var;
    }

    public final void M(int i) {
        this.shortSwipeSize = i;
    }

    public final void N(int i) {
        this.swipeThreshold = i;
    }

    public final void O(h91 h91Var) {
        this.tapAction = h91Var;
    }

    public final o91 b() {
        return this.actionIconDesign;
    }

    public final i3 c() {
        return this.defaultTrigger;
    }

    public final int d() {
        return this.defaultTriggerDelay;
    }

    public final k91 e() {
        return this.design;
    }

    public final List f() {
        return this.longActions;
    }

    public final int g() {
        return this.longSwipeSize;
    }

    public final h91 h() {
        return this.longTapAction;
    }

    public final l91 i() {
        return this.mode;
    }

    public final q91 j() {
        return this.pieDesign;
    }

    public final List k() {
        return this.shortActions;
    }

    public final int l() {
        return this.shortSwipeSize;
    }

    public final int m() {
        return this.swipeThreshold;
    }

    public final h91 n() {
        return this.tapAction;
    }

    public final boolean o() {
        return this.actionVibration;
    }

    public final boolean p() {
        return this.design == k91.actionIcon;
    }

    public final boolean q() {
        return this.design == k91.off;
    }

    public final boolean r() {
        return this.design == k91.pie;
    }

    public final boolean s() {
        return this.mode == l91.off;
    }

    public final boolean t() {
        return this.mode == l91.pieMulti;
    }

    public final boolean u() {
        return this.mode == l91.pieSingle;
    }

    public final void v() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(50);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        arrayList.add(new h91(1, n3.switchToPrevApp, null, i3Var));
        this.shortActions.add(new h91(2, n3.backButton, null, i3Var));
        this.shortActions.add(new h91(1, n3.homeButton, null, i3Var));
        ArrayList arrayList2 = new ArrayList();
        this.longActions = arrayList2;
        arrayList2.add(new h91(1, n3.recentsButton, null, i3Var));
        this.longActions.add(new h91(2, n3Var2, null, i3.instant));
        this.longActions.add(new h91(1, n3.splitScreen, null, i3Var));
    }

    public final void w() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(50);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        arrayList.add(new h91(1, n3.recentsButton, null, i3Var));
        this.shortActions.add(new h91(2, n3.backButton, null, i3Var));
        this.shortActions.add(new h91(1, n3.homeButton, null, i3Var));
        ArrayList arrayList2 = new ArrayList();
        this.longActions = arrayList2;
        n3 n3Var3 = n3.expandQuickSettings;
        wa waVar = j00.k;
        arrayList2.add(new h91(1, n3Var3, waVar, i3Var));
        this.longActions.add(new h91(2, n3Var2, null, i3.instant));
        this.longActions.add(new h91(1, n3.expandNotifications, waVar, i3Var));
    }

    public final void x() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(50);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        n3 n3Var3 = n3.expandQuickSettings;
        wa waVar = j00.k;
        arrayList.add(new h91(1, n3Var3, waVar, i3Var));
        this.shortActions.add(new h91(2, n3.launchCamera, null, i3Var));
        this.shortActions.add(new h91(1, n3.expandNotifications, waVar, i3Var));
        ArrayList arrayList2 = new ArrayList();
        this.longActions = arrayList2;
        arrayList2.add(new h91(1, n3.toggleFlashlight, null, i3Var));
        this.longActions.add(new h91(2, n3Var2, null, i3.instant));
        this.longActions.add(new h91(1, n3.takeScreenshot, null, i3Var));
    }

    public final void y() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(50);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        n3 n3Var3 = n3.expandQuickSettings;
        wa waVar = j00.k;
        arrayList.add(new h91(1, n3Var3, waVar, i3Var));
        this.shortActions.add(new h91(1, n3.launchCamera, null, i3Var));
        this.shortActions.add(new h91(2, n3.switchToPrevApp, null, i3Var));
        this.shortActions.add(new h91(1, n3.openAppDrawer, null, i3Var));
        this.shortActions.add(new h91(1, n3.expandNotifications, waVar, i3Var));
        ArrayList arrayList2 = new ArrayList();
        this.longActions = arrayList2;
        arrayList2.add(new h91(1, n3.toggleFlashlight, null, i3Var));
        this.longActions.add(new h91(1, n3.toggleAutoRotate, null, i3Var));
        this.longActions.add(new h91(2, n3Var2, null, i3.instant));
        this.longActions.add(new h91(1, n3.takeScreenshot, null, i3Var));
        this.longActions.add(new h91(1, n3.lockScreen, null, i3Var));
    }

    public final void z() {
        this.actionVibration = dn.E2;
        this.defaultTrigger = i3.valueOf(dn.F2);
        this.defaultTriggerDelay = dn.G2;
        this.swipeThreshold = ey0.a(50);
        this.shortSwipeSize = ey0.a(60);
        this.longSwipeSize = ey0.a(50);
        n3 n3Var = n3.triggerTap;
        i3 i3Var = i3.empty;
        this.tapAction = new h91(1, n3Var, null, i3Var);
        n3 n3Var2 = n3.grabCursor;
        this.longTapAction = new h91(1, n3Var2, null, i3Var);
        ArrayList arrayList = new ArrayList();
        this.shortActions = arrayList;
        n3 n3Var3 = n3.brightnessSwipe;
        wa waVar = lh.L;
        i3 i3Var2 = i3.instant;
        arrayList.add(new h91(1, n3Var3, waVar, i3Var2));
        this.shortActions.add(new h91(2, n3Var2, null, i3Var2));
        this.shortActions.add(new h91(1, n3.volumeSwipe, mh1.N, i3Var2));
    }
}
