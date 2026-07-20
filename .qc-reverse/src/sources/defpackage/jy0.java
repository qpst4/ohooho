package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import com.quickcursor.App;
import com.quickcursor.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class jy0 extends g1 {
    public static final String k = lc1.K(R.string.screenshot_clipboard_provider_authority);
    public static final wi0 l;
    public static final l3 m;
    public static final SimpleDateFormat n;

    static {
        wi0 wi0Var = new wi0();
        wi0Var.put("copyClipboard", Boolean.valueOf(dn.r2));
        wi0Var.put("saveFile", Boolean.valueOf(dn.s2));
        wi0Var.put("executeAfter", dn.x2);
        wi0Var.put("afterCrop", Boolean.valueOf(dn.t2));
        wi0Var.put("afterShare", Boolean.valueOf(dn.u2));
        wi0Var.put("afterSave", Boolean.valueOf(dn.v2));
        wi0Var.put("afterDelete", Boolean.valueOf(dn.w2));
        l = wi0Var;
        m = new l3(jy0.class, R.string.action_category_general, R.string.action_value_screenshot_clipboard, R.string.action_title_screenshot_clipboard, R.string.action_detail_screenshot_clipboard, R.drawable.icon_action_take_screenshot, 511, 4096, Boolean.TRUE, new ay0(1), null);
        n = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    }

    public static void m(iy0 iy0Var) {
        if (iy0Var.h != null) {
            App.c.getContentResolver().delete(Uri.parse(iy0Var.h), null, null);
            iy0Var.h = null;
        }
    }

    public static Uri n() {
        return q10.d(App.c, k, new File(new File(App.c.getFilesDir(), "screenshot"), "screenshot.jpg"));
    }

    public static void o(iy0 iy0Var) {
        m(iy0Var);
        iy0Var.i.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        iy0Var.h = MediaStore.Images.Media.insertImage(App.c.getContentResolver(), iy0Var.i, "Screenshot_" + n.format(new Date()), (String) null);
    }

    public static void p(iy0 iy0Var, Bitmap bitmap) {
        try {
            iy0Var.i = bitmap;
            File file = new File(App.c.getFilesDir(), "screenshot");
            file.mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "screenshot.jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            si0.b("onSuccess error: " + e.getMessage());
            yb0.y(R.string.general_action_error, 1);
        }
    }

    public static void q() {
        try {
            ((ClipboardManager) App.c.getSystemService("clipboard")).setPrimaryClip(ClipData.newUri(App.c.getContentResolver(), "URI", n()));
        } catch (Exception e) {
            si0.b("onSuccess error: " + e.getMessage());
            yb0.y(R.string.general_action_error, 1);
        }
    }

    public static void r() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", n());
        intent.setType("image/jpeg");
        Intent intentCreateChooser = Intent.createChooser(intent, "Share screenshot");
        intentCreateChooser.setFlags(268435456);
        App.c.startActivity(intentCreateChooser);
    }

    @Override // defpackage.g1
    public final void g() {
        iy0 iy0Var = new iy0(this.g);
        r60.j(true);
        b61.b(new k2(this, 16, iy0Var), 25L);
        b61.b(new s4(12), 500L);
    }
}
