package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.preference.Preference;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bq0 implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
    public final Preference b;

    public bq0(Preference preference) {
        this.b = preference;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.b;
        CharSequence charSequenceI = preference.i();
        if (!preference.D || TextUtils.isEmpty(charSequenceI)) {
            return;
        }
        contextMenu.setHeaderTitle(charSequenceI);
        contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.b;
        Context context = preference.b;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        CharSequence charSequenceI = preference.i();
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceI));
        Toast.makeText(context, context.getString(R.string.preference_copied, charSequenceI), 0).show();
        return true;
    }
}
