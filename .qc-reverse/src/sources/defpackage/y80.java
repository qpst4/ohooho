package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y80 extends k {
    public static final Pattern[][] e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    public final Pattern b;
    public final x80 a = new x80(0);
    public boolean c = false;
    public jl1 d = new jl1(4);

    public y80(Pattern pattern) {
        this.b = pattern;
    }

    @Override // defpackage.k
    public final void a(CharSequence charSequence) {
        jl1 jl1Var = this.d;
        StringBuilder sb = (StringBuilder) jl1Var.c;
        if (jl1Var.b != 0) {
            sb.append('\n');
        }
        sb.append(charSequence);
        jl1Var.b++;
        Pattern pattern = this.b;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.c = true;
    }

    @Override // defpackage.k
    public final void c() {
        Object obj = this.d.c;
        this.d = null;
    }

    @Override // defpackage.k
    public final kg d() {
        return this.a;
    }

    @Override // defpackage.k
    public final lg g(ou ouVar) {
        if (this.c) {
            return null;
        }
        if (ouVar.h && this.b == null) {
            return null;
        }
        return lg.a(ouVar.b);
    }
}
