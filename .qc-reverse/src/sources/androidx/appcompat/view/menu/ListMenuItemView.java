package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.cl0;
import defpackage.ql0;
import defpackage.ra;
import defpackage.zk0;
import defpackage.zs0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements ql0, AbsListView.SelectionBoundsAdjuster {
    public cl0 b;
    public ImageView c;
    public RadioButton d;
    public TextView e;
    public CheckBox f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public final Drawable k;
    public final int l;
    public final Context m;
    public boolean n;
    public final Drawable o;
    public final boolean p;
    public LayoutInflater q;
    public boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ra raVarM = ra.M(getContext(), attributeSet, zs0.r, R.attr.listMenuViewStyle);
        this.k = raVarM.y(5);
        TypedArray typedArray = (TypedArray) raVarM.c;
        this.l = typedArray.getResourceId(1, -1);
        this.n = typedArray.getBoolean(7, false);
        this.m = context;
        this.o = raVarM.y(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.p = typedArrayObtainStyledAttributes.hasValue(0);
        raVarM.O();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        rect.top = this.i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    @Override // defpackage.ql0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.cl0 r11) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(cl0):void");
    }

    @Override // defpackage.ql0
    public cl0 getItemData() {
        return this.b;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.k);
        TextView textView = (TextView) findViewById(R.id.title);
        this.e = textView;
        int i = this.l;
        if (i != -1) {
            textView.setTextAppearance(this.m, i);
        }
        this.g = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.i = (ImageView) findViewById(R.id.group_divider);
        this.j = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.d == null && this.f == null) {
            return;
        }
        if ((this.b.x & 4) != 0) {
            if (this.d == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.d = radioButton;
                LinearLayout linearLayout = this.j;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.d;
            view = this.f;
        } else {
            if (this.f == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f = checkBox;
                LinearLayout linearLayout2 = this.j;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f;
            view = this.d;
        }
        if (z) {
            compoundButton.setChecked(this.b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.d;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.b.x & 4) != 0) {
            if (this.d == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.d = radioButton;
                LinearLayout linearLayout = this.j;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.d;
        } else {
            if (this.f == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f = checkBox;
                LinearLayout linearLayout2 = this.j;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        zk0 zk0Var = this.b.n;
        boolean z = this.r;
        if (z || this.n) {
            ImageView imageView = this.c;
            if (imageView == null && drawable == null && !this.n) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.c = imageView2;
                LinearLayout linearLayout = this.j;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.n) {
                this.c.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.c;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.e;
        if (charSequence == null) {
            if (textView.getVisibility() != 8) {
                this.e.setVisibility(8);
            }
        } else {
            textView.setText(charSequence);
            if (this.e.getVisibility() != 0) {
                this.e.setVisibility(0);
            }
        }
    }
}
