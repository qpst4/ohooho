package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n21 extends LinearLayout {
    public final TextInputLayout b;
    public final AppCompatTextView c;
    public CharSequence d;
    public final CheckableImageButton e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public int h;
    public ImageView.ScaleType i;
    public View.OnLongClickListener j;
    public boolean k;

    public n21(TextInputLayout textInputLayout, ra raVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.b = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.e = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.c = appCompatTextView;
        if (yb0.o(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.j;
        checkableImageButton.setOnClickListener(null);
        xy0.F(checkableImageButton, onLongClickListener);
        this.j = null;
        checkableImageButton.setOnLongClickListener(null);
        xy0.F(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) raVar.c;
        if (typedArray.hasValue(69)) {
            this.f = yb0.h(getContext(), raVar, 69);
        }
        if (typedArray.hasValue(70)) {
            this.g = i1.J(typedArray.getInt(70, -1), null);
        }
        if (typedArray.hasValue(66)) {
            b(raVar.y(66));
            if (typedArray.hasValue(65) && checkableImageButton.getContentDescription() != (text = typedArray.getText(65))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(64, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            zy.n("startIconSize cannot be less than 0");
            throw null;
        }
        if (dimensionPixelSize != this.h) {
            this.h = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(68)) {
            ImageView.ScaleType scaleTypeL = xy0.l(typedArray.getInt(68, -1));
            this.i = scaleTypeL;
            checkableImageButton.setScaleType(scaleTypeL);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = uf1.a;
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(60, 0));
        if (typedArray.hasValue(61)) {
            appCompatTextView.setTextColor(raVar.x(61));
        }
        CharSequence text2 = typedArray.getText(59);
        this.d = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        e();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.e;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        WeakHashMap weakHashMap = uf1.a;
        return this.c.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.e;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f;
            PorterDuff.Mode mode = this.g;
            TextInputLayout textInputLayout = this.b;
            xy0.b(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            xy0.y(textInputLayout, checkableImageButton, this.f);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.j;
        checkableImageButton.setOnClickListener(null);
        xy0.F(checkableImageButton, onLongClickListener);
        this.j = null;
        checkableImageButton.setOnLongClickListener(null);
        xy0.F(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton = this.e;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        int paddingStart;
        EditText editText = this.b.e;
        if (editText == null) {
            return;
        }
        if (this.e.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            WeakHashMap weakHashMap = uf1.a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = uf1.a;
        this.c.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i = (this.d == null || this.k) ? 8 : 0;
        setVisibility((this.e.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.c.setVisibility(i);
        this.b.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
    }
}
