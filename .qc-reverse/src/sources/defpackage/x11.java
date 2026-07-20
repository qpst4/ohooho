package defpackage;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TriggersSettings;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x11 extends ArrayAdapter {
    public final ArrayList a;

    public x11(TriggersSettings triggersSettings, ArrayList arrayList) {
        super(triggersSettings, 0, arrayList);
        this.a = arrayList;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.spinner_icon_item, viewGroup, false);
        }
        w11 w11Var = (w11) getItem(i);
        TextView textView = (TextView) view;
        if (w11Var != null) {
            int i2 = w11Var.a;
            if (this.a.size() == 2) {
                textView.setText(i2 == R.drawable.icon_rotation_portrait ? R.string.settings_triggers_orientation_portrait : R.string.settings_triggers_orientation_landscape);
            } else {
                textView.setText(w11Var.b);
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(getContext().getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup);
    }
}
