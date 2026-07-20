package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.quickcursor.App;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ey0 {
    public static DisplayMetrics a = null;
    public static int b = 3;
    public static int c;
    public static int d;
    public static int e;
    public static float f;
    public static int g;
    public static final rr h = new rr(500, 2000);

    public static int a(int i) {
        return Math.round(TypedValue.applyDimension(1, i, a));
    }

    public static int b() {
        return d() ? e : d;
    }

    public static int c() {
        return d() ? d : e;
    }

    public static boolean d() {
        return b != 2;
    }

    public static void e(Context context) {
        if (!App.d) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int i = point.x;
            int i2 = point.y;
            if (i < i2) {
                b = 1;
                d = i;
                e = i2;
            } else {
                b = 2;
                d = i2;
                e = i;
            }
            c = windowManager.getDefaultDisplay().getRotation();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            a = displayMetrics;
            f = TypedValue.applyDimension(5, 1.0f, displayMetrics);
            return;
        }
        WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        a = displayMetrics2;
        f = TypedValue.applyDimension(5, 1.0f, displayMetrics2);
        Display defaultDisplay2 = windowManager2.getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay2.getRealSize(point2);
        if (!yb0.o) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            Sensor sensor = null;
            for (Sensor sensor2 : sensorManager.getSensorList(-1)) {
                if (sensor2.getName().contains("Hinge Angle") || sensor2.getType() == 36 || sensor2.getStringType().equals("android.sensor.hinge_angle")) {
                    sensor = sensor2;
                }
            }
            if (sensor == null) {
                si0.b("Hinge sensor not detected. Something is wrong");
            } else {
                sensorManager.registerListener(new g80(), sensor, 2);
                yb0.o = true;
            }
        }
        boolean z = yb0.n > 235.0f;
        if (point2.x == 1800 || point2.y == 1800) {
            d = z ? 1350 : 2784;
            e = 1800;
        } else {
            d = z ? 1344 : 2754;
            e = 1892;
        }
        h.a(new jx0(context, z));
        int rotation = windowManager2.getDefaultDisplay().getRotation();
        c = rotation;
        if (rotation == 0 || rotation == 2) {
            b = 1;
        } else {
            b = 2;
        }
    }
}
