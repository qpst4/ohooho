package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z6 extends ArrayAdapter {
    public final /* synthetic */ int a = 1;

    public /* synthetic */ z6(int i, Context context, List list) {
        super(context, i, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        switch (this.a) {
            case 0:
                return i;
            default:
                return super.getItemId(i);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (this.a) {
            case 1:
                jt jtVar = (jt) getItem(i);
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.detailed_list_preference_row, (ViewGroup) null);
                }
                if (jtVar != null) {
                    Object obj = jtVar.a;
                    Object obj2 = jtVar.b;
                    ImageView imageView = (ImageView) view.findViewById(R.id.icon);
                    TextView textView = (TextView) view.findViewById(R.id.text_bottom);
                    if (obj2 != null) {
                        textView.setVisibility(0);
                        textView.setText((CharSequence) obj2);
                    } else {
                        textView.setVisibility(8);
                    }
                    Object obj3 = jtVar.c;
                    if (obj3 != null) {
                        imageView.setImageResource(((Integer) obj3).intValue());
                        imageView.setVisibility(0);
                    } else {
                        imageView.setImageDrawable(null);
                        imageView.setVisibility(8);
                    }
                    Object obj4 = jtVar.d;
                    if (obj4 == null || ((Boolean) obj4).booleanValue()) {
                        ((TextView) view.findViewById(R.id.text_top)).setText((CharSequence) obj);
                        xr.I(view, true);
                    } else {
                        ((TextView) view.findViewById(R.id.text_top)).setText(obj + " 💎 (PRO)");
                        xr.I(view, false);
                    }
                }
                return view;
            default:
                return super.getView(i, view, viewGroup);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        switch (this.a) {
            case 0:
                return true;
            default:
                return super.hasStableIds();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        switch (this.a) {
            case 1:
                Object obj = ((jt) getItem(i)).d;
                return obj == null || ((Boolean) obj).booleanValue();
            default:
                return super.isEnabled(i);
        }
    }

    public /* synthetic */ z6(Context context, int i, int i2, Object[] objArr) {
        super(context, i, i2, objArr);
    }
}
