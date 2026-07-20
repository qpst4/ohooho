package defpackage;

import com.quickcursor.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public enum n3 {
    noPermissionsNeeded(new l3(zm0.class, R.string.action_category_general, R.string.action_value_no_permissions_needed, R.string.action_title_no_permissions_needed, R.string.action_detail_no_permissions_needed, R.drawable.icon_action_no_permissions_needed, 0, 0, Boolean.FALSE, null, null)),
    nothing(zm0.k),
    backButton(jd.k),
    homeButton(n80.k),
    recentsButton(nt0.k),
    expandNotifications(j00.l),
    expandQuickSettings(l00.k),
    takeScreenshot(h41.k),
    screenshotClipboard(jy0.m),
    toggleFlashlight(l61.k),
    lockScreen(li0.k),
    switchToPrevApp(r31.k),
    powerMenuButton(vp0.k),
    copy(vo.l),
    cut(jr.k),
    paste(kp0.k),
    selectAll(zy0.k),
    splitScreen(y11.k),
    openAppDrawer(ho0.k),
    brightnessBar(gh.K),
    brightnessSwipe(lh.M),
    volumeBar(lh1.M),
    volumeSwipe(mh1.O),
    screenRotate(cy0.l),
    toggleBrightness(j61.k),
    toggleAutoRotate(h61.k),
    toggleWifi(q61.k),
    toggleSoundProfile(o61.l),
    toggleDoNotDisturb(k61.k),
    openInternetConnectivity(io0.k),
    openWifiPanel(oo0.k),
    openNfcPanel(jo0.k),
    openVolumeControl(no0.k),
    launchApp(kf0.k),
    launchShortcut(pf0.k),
    launchAssistant(mf0.l),
    launchCamera(nf0.k),
    launchSearch(of0.k),
    mediaPlayPause(rk0.k),
    mediaNext(ok0.k),
    mediaPrevious(sk0.k),
    mediaPlay(qk0.k),
    mediaPause(pk0.k),
    mediaVolumeIncrease(vk0.l),
    mediaVolumeDecrease(uk0.k),
    mediaMuteToggle(nk0.l),
    hideCursor(f80.k),
    grabCursor(d70.l),
    triggerTap(pa1.k),
    triggerLongTap(fa1.k),
    openQuickSettings(ko0.k),
    temporarilyDisable(t41.k),
    timedDisable(x51.l),
    inputDispatcherBug(vb0.k),
    cancelAutoTap(ki.k),
    toggleAutoTapMode(i61.k),
    realtimeGesture(mt0.o),
    startGestureRecorder(o21.l),
    stopGestureRecorder(q21.k),
    openTrackerActionsOnce(mo0.k),
    toggleTrackerActionsAlwaysVisible(p61.k),
    openTrackerActions(lo0.k),
    multiTap(hm0.k),
    longTap(xi0.l),
    doubleTap(qu.l),
    gestureSwipe(o60.l),
    gesturePinchIn(e60.k),
    gesturePinchOut(h60.l),
    gestureNotifications(c60.k),
    gestureQuickSettings(i60.k),
    gestureOpenAppMenu(d60.k),
    gestureBottomTwoFingerSwipe(z50.k),
    taskerShortcut(o41.k),
    macrodroidShortcut(aj0.k),
    automateShortcut(id.k),
    shortcutTriggerCursor(m01.k),
    shortcutHideCursor(a01.k),
    shortcutToggleCursor(j01.k),
    shortcutStartApp(g01.k),
    shortcutStopApp(h01.k),
    shortcutToggleApp(i01.k);

    private final Class<?> actionClass;
    public final k3 actionTypePickedInterceptor;
    public final int categoryId;
    public final int descriptionId;
    public final boolean extraConfigs;
    public final HashMap<String, Object> extras;
    public final int iconId;
    public final int requirements;
    public final int titleId;
    public final int types;
    public final int valueId;

    n3(l3 l3Var) {
        this.actionClass = l3Var.actionClass;
        this.categoryId = l3Var.categoryId;
        this.valueId = l3Var.valueId;
        this.titleId = l3Var.titleId;
        this.descriptionId = l3Var.descriptionId;
        this.iconId = l3Var.iconId;
        this.types = l3Var.types;
        this.requirements = l3Var.requirements;
        this.extraConfigs = l3Var.extraConfigs;
        this.actionTypePickedInterceptor = l3Var.actionTypePickedInterceptor;
        this.extras = l3Var.extras;
    }

    public static List b(final int i) {
        return (List) Arrays.asList(values()).stream().filter(new Predicate() { // from class: j3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return xr.y(((n3) obj).types, i);
            }
        }).collect(Collectors.toList());
    }

    public final Class a() {
        return this.actionClass;
    }
}
