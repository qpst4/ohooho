package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b9 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static b9 c;
    public bw0 a;

    public static synchronized b9 a() {
        try {
            if (c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        return bw0.e(i, mode);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v9, types: [int[], java.io.Serializable] */
    public static synchronized void d() {
        if (c == null) {
            b9 b9Var = new b9();
            c = b9Var;
            b9Var.a = bw0.b();
            bw0 bw0Var = c.a;
            a9 a9Var = new a9();
            a9Var.a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            a9Var.b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            a9Var.c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            a9Var.d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            a9Var.e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            a9Var.f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
            synchronized (bw0Var) {
                bw0Var.e = a9Var;
            }
        }
    }

    public static void e(Drawable drawable, zm zmVar, int[] iArr) {
        PorterDuff.Mode mode = bw0.f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = zmVar.b;
        if (!z && !zmVar.a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterE = null;
        ColorStateList colorStateList = z ? (ColorStateList) zmVar.c : null;
        PorterDuff.Mode mode2 = zmVar.a ? (PorterDuff.Mode) zmVar.d : bw0.f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterE = bw0.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterE);
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.a.c(context, i);
    }
}
