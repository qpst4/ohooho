package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w60 extends x60 {
    public static final Object b = new Object();
    public static final w60 c = new w60();

    public static AlertDialog d(Activity activity, int i, ak1 ak1Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(pj1.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(com.quickcursor.R.string.common_google_play_services_enable_button) : resources.getString(com.quickcursor.R.string.common_google_play_services_update_button) : resources.getString(com.quickcursor.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, ak1Var);
        }
        String strC = pj1.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", qq0.i("Creating dialog for Google Play services availability issue. ConnectionResult=", i), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof z7) {
                y30 y30VarW = ((z7) activity).w();
                j31 j31Var = new j31();
                xy0.e("Cannot display null dialog", alertDialog);
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                j31Var.o0 = alertDialog;
                if (onCancelListener != null) {
                    j31Var.p0 = onCancelListener;
                }
                j31Var.j0(y30VarW, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        nz nzVar = new nz();
        xy0.e("Cannot display null dialog", alertDialog);
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        nzVar.b = alertDialog;
        if (onCancelListener != null) {
            nzVar.c = onCancelListener;
        }
        nzVar.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i, new vj1(super.a(i, googleApiActivity, "d"), googleApiActivity), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        Bundle bundle;
        int i3;
        ArrayList arrayList;
        int i4;
        Log.w("GoogleApiAvailability", "GMS core API Availability. ConnectionResult=" + i + ", tag=null", new IllegalArgumentException());
        if (i == 18) {
            new xj1(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i == 6 ? pj1.e(context, "common_google_play_services_resolution_required_title") : pj1.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(com.quickcursor.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? pj1.d(context, "common_google_play_services_resolution_required_text", pj1.a(context)) : pj1.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        xy0.d(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        bn0 bn0Var = new bn0();
        ArrayList arrayList2 = new ArrayList();
        bn0Var.b = arrayList2;
        bn0Var.c = new ArrayList();
        bn0Var.d = new ArrayList();
        bn0Var.i = true;
        bn0Var.k = false;
        Notification notification = new Notification();
        bn0Var.o = notification;
        bn0Var.a = context;
        bn0Var.m = null;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        bn0Var.h = 0;
        bn0Var.p = new ArrayList();
        bn0Var.n = true;
        bn0Var.k = true;
        notification.flags |= 16;
        bn0Var.e = bn0.a(strE);
        i9 i9Var = new i9(29);
        i9Var.d = bn0.a(strD);
        bn0Var.b(i9Var);
        PackageManager packageManager = context.getPackageManager();
        if (xy0.h == null) {
            xy0.h = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (xy0.h.booleanValue()) {
            notification.icon = context.getApplicationInfo().icon;
            bn0Var.h = 2;
            if (xy0.s(context)) {
                arrayList2.add(new an0(resources.getString(com.quickcursor.R.string.common_open_on_phone), pendingIntent));
            } else {
                bn0Var.g = pendingIntent;
            }
        } else {
            notification.icon = R.drawable.stat_sys_warning;
            notification.tickerText = bn0.a(resources.getString(com.quickcursor.R.string.common_google_play_services_notification_ticker));
            notification.when = System.currentTimeMillis();
            bn0Var.g = pendingIntent;
            bn0Var.f = bn0.a(strD);
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            if (i5 < 26) {
                throw new IllegalStateException();
            }
            synchronized (b) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.quickcursor.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(c0.g(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            bn0Var.m = "com.google.android.gms.availability";
        }
        new ArrayList();
        Bundle bundle2 = new Bundle();
        Context context2 = bn0Var.a;
        ArrayList arrayList3 = bn0Var.p;
        ArrayList arrayList4 = bn0Var.c;
        ArrayList arrayList5 = bn0Var.d;
        Notification.Builder builderA = Build.VERSION.SDK_INT >= 26 ? pa0.a(context2, bn0Var.m) : new Notification.Builder(context2);
        Notification notification2 = bn0Var.o;
        ArrayList arrayList6 = arrayList5;
        builderA.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, null).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(bn0Var.e).setContentText(bn0Var.f).setContentInfo(null).setContentIntent(bn0Var.g).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(null, (notification2.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        builderA.setLargeIcon((Icon) null);
        builderA.setSubText(null).setUsesChronometer(false).setPriority(bn0Var.h);
        ArrayList arrayList7 = bn0Var.b;
        int size = arrayList7.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList7.get(i6);
            int i7 = i6 + 1;
            an0 an0Var = (an0) obj;
            ArrayList arrayList8 = arrayList7;
            if (an0Var.b == null && (i4 = an0Var.e) != 0) {
                an0Var.b = IconCompat.b(i4);
            }
            IconCompat iconCompat = an0Var.b;
            int i8 = size;
            boolean z = an0Var.c;
            Bundle bundle3 = an0Var.a;
            NotificationManager notificationManager2 = notificationManager;
            int i9 = i5;
            Notification.Action.Builder builder = new Notification.Action.Builder(iconCompat != null ? iconCompat.g(null) : null, an0Var.f, an0Var.g);
            Bundle bundle4 = bundle3 != null ? new Bundle(bundle3) : new Bundle();
            bundle4.putBoolean("android.support.allowGeneratedReplies", z);
            builder.setAllowGeneratedReplies(z);
            bundle4.putInt("android.support.action.semanticAction", 0);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                ju.n(builder);
            }
            if (i10 >= 29) {
                ua.j(builder);
            }
            if (i10 >= 31) {
                cn0.a(builder);
            }
            bundle4.putBoolean("android.support.action.showsUserInterface", an0Var.d);
            builder.addExtras(bundle4);
            builderA.addAction(builder.build());
            arrayList7 = arrayList8;
            size = i8;
            i6 = i7;
            notificationManager = notificationManager2;
            i5 = i9;
        }
        int i11 = i5;
        NotificationManager notificationManager3 = notificationManager;
        Bundle bundle5 = bn0Var.l;
        if (bundle5 != null) {
            bundle2.putAll(bundle5);
        }
        builderA.setShowWhen(bn0Var.i);
        builderA.setLocalOnly(bn0Var.k);
        builderA.setGroup(null);
        builderA.setSortKey(null);
        builderA.setGroupSummary(false);
        builderA.setCategory(null);
        builderA.setColor(0);
        builderA.setVisibility(0);
        builderA.setPublicVersion(null);
        builderA.setSound(notification2.sound, notification2.audioAttributes);
        if (Build.VERSION.SDK_INT < 28) {
            if (arrayList4 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList4.size());
                int size2 = arrayList4.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = arrayList4.get(i12);
                    i12++;
                    np0 np0Var = (np0) obj2;
                    String str = np0Var.a;
                    String str2 = np0Var.b;
                    if (str2 == null) {
                        if (str != null) {
                            str2 = "name:" + ((Object) str);
                        } else {
                            str2 = "";
                        }
                    }
                    arrayList.add(str2);
                }
            }
            if (arrayList != null) {
                if (arrayList3 == null) {
                    arrayList3 = arrayList;
                } else {
                    mb mbVar = new mb(arrayList3.size() + arrayList.size());
                    mbVar.addAll(arrayList);
                    mbVar.addAll(arrayList3);
                    arrayList3 = new ArrayList(mbVar);
                }
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size3 = arrayList3.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj3 = arrayList3.get(i13);
                i13++;
                builderA.addPerson((String) obj3);
            }
        }
        if (arrayList6.size() > 0) {
            if (bn0Var.l == null) {
                bn0Var.l = new Bundle();
            }
            Bundle bundle6 = bn0Var.l.getBundle("android.car.EXTENSIONS");
            if (bundle6 == null) {
                bundle6 = new Bundle();
            }
            Bundle bundle7 = new Bundle(bundle6);
            Bundle bundle8 = new Bundle();
            int i14 = 0;
            while (i14 < arrayList6.size()) {
                String string2 = Integer.toString(i14);
                ArrayList arrayList9 = arrayList6;
                an0 an0Var2 = (an0) arrayList9.get(i14);
                Bundle bundle9 = new Bundle();
                if (an0Var2.b == null && (i3 = an0Var2.e) != 0) {
                    an0Var2.b = IconCompat.b(i3);
                }
                IconCompat iconCompat2 = an0Var2.b;
                int i15 = i14;
                Bundle bundle10 = an0Var2.a;
                arrayList6 = arrayList9;
                bundle9.putInt("icon", iconCompat2 != null ? iconCompat2.c() : 0);
                bundle9.putCharSequence("title", an0Var2.f);
                bundle9.putParcelable("actionIntent", an0Var2.g);
                Bundle bundle11 = bundle10 != null ? new Bundle(bundle10) : new Bundle();
                bundle11.putBoolean("android.support.allowGeneratedReplies", an0Var2.c);
                bundle9.putBundle("extras", bundle11);
                bundle9.putParcelableArray("remoteInputs", null);
                bundle9.putBoolean("showsUserInterface", an0Var2.d);
                bundle9.putInt("semanticAction", 0);
                bundle8.putBundle(string2, bundle9);
                i14 = i15 + 1;
            }
            bundle6.putBundle("invisible_actions", bundle8);
            bundle7.putBundle("invisible_actions", bundle8);
            if (bn0Var.l == null) {
                bn0Var.l = new Bundle();
            }
            bn0Var.l.putBundle("android.car.EXTENSIONS", bundle6);
            bundle2.putBundle("android.car.EXTENSIONS", bundle7);
        }
        builderA.setExtras(bn0Var.l);
        builderA.setRemoteInputHistory(null);
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 26) {
            pa0.f(builderA);
            pa0.l(builderA);
            pa0.m(builderA);
            pa0.n(builderA);
            pa0.h(builderA);
            if (!TextUtils.isEmpty(bn0Var.m)) {
                builderA.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i16 >= 28) {
            int size4 = arrayList4.size();
            int i17 = 0;
            while (i17 < size4) {
                Object obj4 = arrayList4.get(i17);
                i17++;
                np0 np0Var2 = (np0) obj4;
                np0Var2.getClass();
                ju.a(builderA, ju.p(np0Var2));
            }
        }
        int i18 = Build.VERSION.SDK_INT;
        if (i18 >= 29) {
            ua.h(builderA, bn0Var.n);
            ua.i(builderA);
        }
        if (i18 >= 36) {
            l0.e(builderA);
        }
        i9 i9Var2 = bn0Var.j;
        if (i9Var2 != null) {
            new Notification.BigTextStyle(builderA).setBigContentTitle(null).bigText((CharSequence) i9Var2.d);
        }
        Notification notificationBuild = i11 >= 26 ? builderA.build() : builderA.build();
        if (i9Var2 != null) {
            bn0Var.j.getClass();
        }
        if (i9Var2 != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        if (i == 1 || i == 2 || i == 3) {
            b70.a.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager3.notify(i2, notificationBuild);
    }

    public final void g(Activity activity, eg0 eg0Var, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i, new zj1(super.a(i, activity, "d"), eg0Var), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
