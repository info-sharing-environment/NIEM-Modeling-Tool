package org.search.niem.uml.papyrus.textedit.property.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.search.niem.uml.papyrus.textedit.property.xtext.services.NIEMUmlPropertyGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNIEMUmlPropertyParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'*'", "'none'", "'shared'", "'composite'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "':'", "'@'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'redefines'", "'subsets'", "'='", "'/'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalNIEMUmlPropertyParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNIEMUmlPropertyParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNIEMUmlPropertyParser.tokenNames; }
    public String getGrammarFileName() { return "../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g"; }


     
     	private NIEMUmlPropertyGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(NIEMUmlPropertyGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRulePropertyRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:60:1: entryRulePropertyRule : rulePropertyRule EOF ;
    public final void entryRulePropertyRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:61:1: ( rulePropertyRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:62:1: rulePropertyRule EOF
            {
             before(grammarAccess.getPropertyRuleRule()); 
            pushFollow(FOLLOW_rulePropertyRule_in_entryRulePropertyRule61);
            rulePropertyRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyRule68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertyRule"


    // $ANTLR start "rulePropertyRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:69:1: rulePropertyRule : ( ( rule__PropertyRule__Group__0 ) ) ;
    public final void rulePropertyRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:73:2: ( ( ( rule__PropertyRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:74:1: ( ( rule__PropertyRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:74:1: ( ( rule__PropertyRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:75:1: ( rule__PropertyRule__Group__0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:76:1: ( rule__PropertyRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:76:2: rule__PropertyRule__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0_in_rulePropertyRule94);
            rule__PropertyRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyRule"


    // $ANTLR start "entryRuleAggregationRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:88:1: entryRuleAggregationRule : ruleAggregationRule EOF ;
    public final void entryRuleAggregationRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:89:1: ( ruleAggregationRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:90:1: ruleAggregationRule EOF
            {
             before(grammarAccess.getAggregationRuleRule()); 
            pushFollow(FOLLOW_ruleAggregationRule_in_entryRuleAggregationRule121);
            ruleAggregationRule();

            state._fsp--;

             after(grammarAccess.getAggregationRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAggregationRule128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAggregationRule"


    // $ANTLR start "ruleAggregationRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:97:1: ruleAggregationRule : ( ( rule__AggregationRule__Group__0 ) ) ;
    public final void ruleAggregationRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:101:2: ( ( ( rule__AggregationRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:102:1: ( ( rule__AggregationRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:102:1: ( ( rule__AggregationRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:103:1: ( rule__AggregationRule__Group__0 )
            {
             before(grammarAccess.getAggregationRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:104:1: ( rule__AggregationRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:104:2: rule__AggregationRule__Group__0
            {
            pushFollow(FOLLOW_rule__AggregationRule__Group__0_in_ruleAggregationRule154);
            rule__AggregationRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAggregationRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAggregationRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:116:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:117:1: ( ruleTypeRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:118:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule181);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getTypeRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:125:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:129:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:130:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:130:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:131:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:132:1: ( rule__TypeRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:132:2: rule__TypeRule__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule214);
            rule__TypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:145:1: ( ruleQualifiedName EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:146:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName241);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:153:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:157:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:159:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:160:1: ( rule__QualifiedName__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:160:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName274);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:172:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:173:1: ( ruleMultiplicityRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:174:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule301);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicityRule"


    // $ANTLR start "ruleMultiplicityRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:181:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:185:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:186:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:186:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:187:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:188:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:188:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule334);
            rule__MultiplicityRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicityRule"


    // $ANTLR start "entryRuleBoundSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:200:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:201:1: ( ruleBoundSpecification EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:202:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification361);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoundSpecification"


    // $ANTLR start "ruleBoundSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:209:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:213:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:214:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:214:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:215:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:216:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:216:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification394);
            rule__BoundSpecification__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoundSpecification"


    // $ANTLR start "entryRuleUnlimitedLiteral"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:228:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
    public final void entryRuleUnlimitedLiteral() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:229:1: ( ruleUnlimitedLiteral EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:230:1: ruleUnlimitedLiteral EOF
            {
             before(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral421);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getUnlimitedLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnlimitedLiteral"


    // $ANTLR start "ruleUnlimitedLiteral"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:237:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
    public final void ruleUnlimitedLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:241:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:242:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:242:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:243:1: ( rule__UnlimitedLiteral__Alternatives )
            {
             before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:244:1: ( rule__UnlimitedLiteral__Alternatives )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:244:2: rule__UnlimitedLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral454);
            rule__UnlimitedLiteral__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnlimitedLiteral"


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:256:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:257:1: ( ruleModifiersRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:258:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule481);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getModifiersRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModifiersRule"


    // $ANTLR start "ruleModifiersRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:265:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:269:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:270:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:270:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:271:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:272:1: ( rule__ModifiersRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:272:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule514);
            rule__ModifiersRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModifiersRule"


    // $ANTLR start "entryRuleModifierSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:284:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:285:1: ( ruleModifierSpecification EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:286:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification541);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModifierSpecification"


    // $ANTLR start "ruleModifierSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:293:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__Alternatives ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:297:2: ( ( ( rule__ModifierSpecification__Alternatives ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:298:1: ( ( rule__ModifierSpecification__Alternatives ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:298:1: ( ( rule__ModifierSpecification__Alternatives ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:299:1: ( rule__ModifierSpecification__Alternatives )
            {
             before(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:300:1: ( rule__ModifierSpecification__Alternatives )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:300:2: rule__ModifierSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification574);
            rule__ModifierSpecification__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModifierSpecification"


    // $ANTLR start "entryRuleRedefinesRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:312:1: entryRuleRedefinesRule : ruleRedefinesRule EOF ;
    public final void entryRuleRedefinesRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:313:1: ( ruleRedefinesRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:314:1: ruleRedefinesRule EOF
            {
             before(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule601);
            ruleRedefinesRule();

            state._fsp--;

             after(grammarAccess.getRedefinesRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRedefinesRule"


    // $ANTLR start "ruleRedefinesRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:321:1: ruleRedefinesRule : ( ( rule__RedefinesRule__Group__0 ) ) ;
    public final void ruleRedefinesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:325:2: ( ( ( rule__RedefinesRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:326:1: ( ( rule__RedefinesRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:326:1: ( ( rule__RedefinesRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:327:1: ( rule__RedefinesRule__Group__0 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:328:1: ( rule__RedefinesRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:328:2: rule__RedefinesRule__Group__0
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule634);
            rule__RedefinesRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRedefinesRule"


    // $ANTLR start "entryRuleSubsetsRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:340:1: entryRuleSubsetsRule : ruleSubsetsRule EOF ;
    public final void entryRuleSubsetsRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:341:1: ( ruleSubsetsRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:342:1: ruleSubsetsRule EOF
            {
             before(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule661);
            ruleSubsetsRule();

            state._fsp--;

             after(grammarAccess.getSubsetsRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubsetsRule"


    // $ANTLR start "ruleSubsetsRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:349:1: ruleSubsetsRule : ( ( rule__SubsetsRule__Group__0 ) ) ;
    public final void ruleSubsetsRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:353:2: ( ( ( rule__SubsetsRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:354:1: ( ( rule__SubsetsRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:354:1: ( ( rule__SubsetsRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:355:1: ( rule__SubsetsRule__Group__0 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:356:1: ( rule__SubsetsRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:356:2: rule__SubsetsRule__Group__0
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule694);
            rule__SubsetsRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubsetsRule"


    // $ANTLR start "entryRuleDefaultValueRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:368:1: entryRuleDefaultValueRule : ruleDefaultValueRule EOF ;
    public final void entryRuleDefaultValueRule() throws RecognitionException {
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:369:1: ( ruleDefaultValueRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:370:1: ruleDefaultValueRule EOF
            {
             before(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule721);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getDefaultValueRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule728); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDefaultValueRule"


    // $ANTLR start "ruleDefaultValueRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:377:1: ruleDefaultValueRule : ( ( rule__DefaultValueRule__Group__0 ) ) ;
    public final void ruleDefaultValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:381:2: ( ( ( rule__DefaultValueRule__Group__0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:382:1: ( ( rule__DefaultValueRule__Group__0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:382:1: ( ( rule__DefaultValueRule__Group__0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:383:1: ( rule__DefaultValueRule__Group__0 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getGroup()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:384:1: ( rule__DefaultValueRule__Group__0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:384:2: rule__DefaultValueRule__Group__0
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule754);
            rule__DefaultValueRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDefaultValueRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefaultValueRule"


    // $ANTLR start "ruleAggregationKind"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:397:1: ruleAggregationKind : ( ( rule__AggregationKind__Alternatives ) ) ;
    public final void ruleAggregationKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:401:1: ( ( ( rule__AggregationKind__Alternatives ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:402:1: ( ( rule__AggregationKind__Alternatives ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:402:1: ( ( rule__AggregationKind__Alternatives ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:403:1: ( rule__AggregationKind__Alternatives )
            {
             before(grammarAccess.getAggregationKindAccess().getAlternatives()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:404:1: ( rule__AggregationKind__Alternatives )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:404:2: rule__AggregationKind__Alternatives
            {
            pushFollow(FOLLOW_rule__AggregationKind__Alternatives_in_ruleAggregationKind791);
            rule__AggregationKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAggregationKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAggregationKind"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:416:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:420:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:421:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:421:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:422:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:423:1: ( rule__VisibilityKind__Alternatives )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:423:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind827);
            rule__VisibilityKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVisibilityKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVisibilityKind"


    // $ANTLR start "ruleModifierKind"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:435:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:439:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:440:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:440:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:441:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:442:1: ( rule__ModifierKind__Alternatives )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:442:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind863);
            rule__ModifierKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModifierKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModifierKind"


    // $ANTLR start "rule__PropertyRule__Alternatives_4"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:453:1: rule__PropertyRule__Alternatives_4 : ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__PropertyRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:457:1: ( ( ( rule__PropertyRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:458:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:458:1: ( ( rule__PropertyRule__TypeAssignment_4_0 ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:459:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:460:1: ( rule__PropertyRule__TypeAssignment_4_0 )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:460:2: rule__PropertyRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4898);
                    rule__PropertyRule__TypeAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPropertyRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:464:6: ( '<Undefined>' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:464:6: ( '<Undefined>' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:465:1: '<Undefined>'
                    {
                     before(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,11,FOLLOW_11_in_rule__PropertyRule__Alternatives_4917); 
                     after(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Alternatives_4"


    // $ANTLR start "rule__UnlimitedLiteral__Alternatives"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:477:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:481:1: ( ( RULE_INT ) | ( '*' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:482:1: ( RULE_INT )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:482:1: ( RULE_INT )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:483:1: RULE_INT
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives951); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:488:6: ( '*' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:488:6: ( '*' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:489:1: '*'
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__UnlimitedLiteral__Alternatives969); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnlimitedLiteral__Alternatives"


    // $ANTLR start "rule__ModifierSpecification__Alternatives"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:501:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );
    public final void rule__ModifierSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:505:1: ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 20:
            case 21:
            case 22:
            case 23:
                {
                alt3=1;
                }
                break;
            case 33:
                {
                alt3=2;
                }
                break;
            case 34:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:506:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:506:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:507:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:508:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:508:2: rule__ModifierSpecification__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives1003);
                    rule__ModifierSpecification__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:512:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:512:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:513:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:514:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:514:2: rule__ModifierSpecification__RedefinesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives1021);
                    rule__ModifierSpecification__RedefinesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:518:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:518:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:519:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:520:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:520:2: rule__ModifierSpecification__SubsetsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives1039);
                    rule__ModifierSpecification__SubsetsAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__Alternatives"


    // $ANTLR start "rule__AggregationKind__Alternatives"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:529:1: rule__AggregationKind__Alternatives : ( ( ( 'none' ) ) | ( ( 'shared' ) ) | ( ( 'composite' ) ) );
    public final void rule__AggregationKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:533:1: ( ( ( 'none' ) ) | ( ( 'shared' ) ) | ( ( 'composite' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:534:1: ( ( 'none' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:534:1: ( ( 'none' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:535:1: ( 'none' )
                    {
                     before(grammarAccess.getAggregationKindAccess().getNoneEnumLiteralDeclaration_0()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:536:1: ( 'none' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:536:3: 'none'
                    {
                    match(input,13,FOLLOW_13_in_rule__AggregationKind__Alternatives1073); 

                    }

                     after(grammarAccess.getAggregationKindAccess().getNoneEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:541:6: ( ( 'shared' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:541:6: ( ( 'shared' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:542:1: ( 'shared' )
                    {
                     before(grammarAccess.getAggregationKindAccess().getSharedEnumLiteralDeclaration_1()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:543:1: ( 'shared' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:543:3: 'shared'
                    {
                    match(input,14,FOLLOW_14_in_rule__AggregationKind__Alternatives1094); 

                    }

                     after(grammarAccess.getAggregationKindAccess().getSharedEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:548:6: ( ( 'composite' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:548:6: ( ( 'composite' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:549:1: ( 'composite' )
                    {
                     before(grammarAccess.getAggregationKindAccess().getCompositeEnumLiteralDeclaration_2()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:550:1: ( 'composite' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:550:3: 'composite'
                    {
                    match(input,15,FOLLOW_15_in_rule__AggregationKind__Alternatives1115); 

                    }

                     after(grammarAccess.getAggregationKindAccess().getCompositeEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AggregationKind__Alternatives"


    // $ANTLR start "rule__VisibilityKind__Alternatives"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:560:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:564:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            case 19:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:565:1: ( ( '+' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:565:1: ( ( '+' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:566:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:567:1: ( '+' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:567:3: '+'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives1151); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:572:6: ( ( '-' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:572:6: ( ( '-' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:573:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:574:1: ( '-' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:574:3: '-'
                    {
                    match(input,17,FOLLOW_17_in_rule__VisibilityKind__Alternatives1172); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:579:6: ( ( '#' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:579:6: ( ( '#' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:580:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:581:1: ( '#' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:581:3: '#'
                    {
                    match(input,18,FOLLOW_18_in_rule__VisibilityKind__Alternatives1193); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:586:6: ( ( '~' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:586:6: ( ( '~' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:587:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:588:1: ( '~' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:588:3: '~'
                    {
                    match(input,19,FOLLOW_19_in_rule__VisibilityKind__Alternatives1214); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VisibilityKind__Alternatives"


    // $ANTLR start "rule__ModifierKind__Alternatives"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:598:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:602:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case 22:
                {
                alt6=3;
                }
                break;
            case 23:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:603:1: ( ( 'readOnly' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:603:1: ( ( 'readOnly' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:604:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:605:1: ( 'readOnly' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:605:3: 'readOnly'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives1250); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:610:6: ( ( 'union' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:610:6: ( ( 'union' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:611:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:612:1: ( 'union' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:612:3: 'union'
                    {
                    match(input,21,FOLLOW_21_in_rule__ModifierKind__Alternatives1271); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:617:6: ( ( 'ordered' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:617:6: ( ( 'ordered' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:618:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:619:1: ( 'ordered' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:619:3: 'ordered'
                    {
                    match(input,22,FOLLOW_22_in_rule__ModifierKind__Alternatives1292); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:624:6: ( ( 'unique' ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:624:6: ( ( 'unique' ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:625:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:626:1: ( 'unique' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:626:3: 'unique'
                    {
                    match(input,23,FOLLOW_23_in_rule__ModifierKind__Alternatives1313); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierKind__Alternatives"


    // $ANTLR start "rule__PropertyRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:638:1: rule__PropertyRule__Group__0 : rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 ;
    public final void rule__PropertyRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:642:1: ( rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:643:2: rule__PropertyRule__Group__0__Impl rule__PropertyRule__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__01346);
            rule__PropertyRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__01349);
            rule__PropertyRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__0"


    // $ANTLR start "rule__PropertyRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:650:1: rule__PropertyRule__Group__0__Impl : ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) ;
    public final void rule__PropertyRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:654:1: ( ( ( rule__PropertyRule__VisibilityAssignment_0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:655:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:655:1: ( ( rule__PropertyRule__VisibilityAssignment_0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:656:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:657:1: ( rule__PropertyRule__VisibilityAssignment_0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:657:2: rule__PropertyRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl1376);
            rule__PropertyRule__VisibilityAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getVisibilityAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__0__Impl"


    // $ANTLR start "rule__PropertyRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:667:1: rule__PropertyRule__Group__1 : rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 ;
    public final void rule__PropertyRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:671:1: ( rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:672:2: rule__PropertyRule__Group__1__Impl rule__PropertyRule__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__11406);
            rule__PropertyRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__11409);
            rule__PropertyRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__1"


    // $ANTLR start "rule__PropertyRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:679:1: rule__PropertyRule__Group__1__Impl : ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) ;
    public final void rule__PropertyRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:683:1: ( ( ( rule__PropertyRule__IsDerivedAssignment_1 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:684:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:684:1: ( ( rule__PropertyRule__IsDerivedAssignment_1 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:685:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:686:1: ( rule__PropertyRule__IsDerivedAssignment_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==36) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:686:2: rule__PropertyRule__IsDerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl1436);
                    rule__PropertyRule__IsDerivedAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getIsDerivedAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__1__Impl"


    // $ANTLR start "rule__PropertyRule__Group__2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:696:1: rule__PropertyRule__Group__2 : rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 ;
    public final void rule__PropertyRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:700:1: ( rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:701:2: rule__PropertyRule__Group__2__Impl rule__PropertyRule__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__21467);
            rule__PropertyRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__21470);
            rule__PropertyRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__2"


    // $ANTLR start "rule__PropertyRule__Group__2__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:708:1: rule__PropertyRule__Group__2__Impl : ( ( rule__PropertyRule__NameAssignment_2 ) ) ;
    public final void rule__PropertyRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:712:1: ( ( ( rule__PropertyRule__NameAssignment_2 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:713:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:713:1: ( ( rule__PropertyRule__NameAssignment_2 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:714:1: ( rule__PropertyRule__NameAssignment_2 )
            {
             before(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:715:1: ( rule__PropertyRule__NameAssignment_2 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:715:2: rule__PropertyRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl1497);
            rule__PropertyRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__2__Impl"


    // $ANTLR start "rule__PropertyRule__Group__3"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:725:1: rule__PropertyRule__Group__3 : rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 ;
    public final void rule__PropertyRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:729:1: ( rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:730:2: rule__PropertyRule__Group__3__Impl rule__PropertyRule__Group__4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__31527);
            rule__PropertyRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__31530);
            rule__PropertyRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__3"


    // $ANTLR start "rule__PropertyRule__Group__3__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:737:1: rule__PropertyRule__Group__3__Impl : ( ':' ) ;
    public final void rule__PropertyRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:741:1: ( ( ':' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:742:1: ( ':' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:742:1: ( ':' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:743:1: ':'
            {
             before(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__PropertyRule__Group__3__Impl1558); 
             after(grammarAccess.getPropertyRuleAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__3__Impl"


    // $ANTLR start "rule__PropertyRule__Group__4"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:756:1: rule__PropertyRule__Group__4 : rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 ;
    public final void rule__PropertyRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:760:1: ( rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:761:2: rule__PropertyRule__Group__4__Impl rule__PropertyRule__Group__5
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41589);
            rule__PropertyRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41592);
            rule__PropertyRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__4"


    // $ANTLR start "rule__PropertyRule__Group__4__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:768:1: rule__PropertyRule__Group__4__Impl : ( ( rule__PropertyRule__Alternatives_4 ) ) ;
    public final void rule__PropertyRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:772:1: ( ( ( rule__PropertyRule__Alternatives_4 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:773:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:773:1: ( ( rule__PropertyRule__Alternatives_4 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:774:1: ( rule__PropertyRule__Alternatives_4 )
            {
             before(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:775:1: ( rule__PropertyRule__Alternatives_4 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:775:2: rule__PropertyRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1619);
            rule__PropertyRule__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getPropertyRuleAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__4__Impl"


    // $ANTLR start "rule__PropertyRule__Group__5"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:785:1: rule__PropertyRule__Group__5 : rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 ;
    public final void rule__PropertyRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:789:1: ( rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:790:2: rule__PropertyRule__Group__5__Impl rule__PropertyRule__Group__6
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51649);
            rule__PropertyRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51652);
            rule__PropertyRule__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__5"


    // $ANTLR start "rule__PropertyRule__Group__5__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:797:1: rule__PropertyRule__Group__5__Impl : ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__PropertyRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:801:1: ( ( ( rule__PropertyRule__MultiplicityAssignment_5 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:802:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:802:1: ( ( rule__PropertyRule__MultiplicityAssignment_5 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:803:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:804:1: ( rule__PropertyRule__MultiplicityAssignment_5 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:804:2: rule__PropertyRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1679);
                    rule__PropertyRule__MultiplicityAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getMultiplicityAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__5__Impl"


    // $ANTLR start "rule__PropertyRule__Group__6"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:814:1: rule__PropertyRule__Group__6 : rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7 ;
    public final void rule__PropertyRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:818:1: ( rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:819:2: rule__PropertyRule__Group__6__Impl rule__PropertyRule__Group__7
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61710);
            rule__PropertyRule__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__7_in_rule__PropertyRule__Group__61713);
            rule__PropertyRule__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__6"


    // $ANTLR start "rule__PropertyRule__Group__6__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:826:1: rule__PropertyRule__Group__6__Impl : ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) ;
    public final void rule__PropertyRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:830:1: ( ( ( rule__PropertyRule__ModifiersAssignment_6 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:831:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:831:1: ( ( rule__PropertyRule__ModifiersAssignment_6 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:832:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:833:1: ( rule__PropertyRule__ModifiersAssignment_6 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==30) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:833:2: rule__PropertyRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1740);
                    rule__PropertyRule__ModifiersAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getModifiersAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__6__Impl"


    // $ANTLR start "rule__PropertyRule__Group__7"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:843:1: rule__PropertyRule__Group__7 : rule__PropertyRule__Group__7__Impl rule__PropertyRule__Group__8 ;
    public final void rule__PropertyRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:847:1: ( rule__PropertyRule__Group__7__Impl rule__PropertyRule__Group__8 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:848:2: rule__PropertyRule__Group__7__Impl rule__PropertyRule__Group__8
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__7__Impl_in_rule__PropertyRule__Group__71771);
            rule__PropertyRule__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyRule__Group__8_in_rule__PropertyRule__Group__71774);
            rule__PropertyRule__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__7"


    // $ANTLR start "rule__PropertyRule__Group__7__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:855:1: rule__PropertyRule__Group__7__Impl : ( ( rule__PropertyRule__AggregationAssignment_7 )? ) ;
    public final void rule__PropertyRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:859:1: ( ( ( rule__PropertyRule__AggregationAssignment_7 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:860:1: ( ( rule__PropertyRule__AggregationAssignment_7 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:860:1: ( ( rule__PropertyRule__AggregationAssignment_7 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:861:1: ( rule__PropertyRule__AggregationAssignment_7 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getAggregationAssignment_7()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:862:1: ( rule__PropertyRule__AggregationAssignment_7 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:862:2: rule__PropertyRule__AggregationAssignment_7
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__AggregationAssignment_7_in_rule__PropertyRule__Group__7__Impl1801);
                    rule__PropertyRule__AggregationAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getAggregationAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__7__Impl"


    // $ANTLR start "rule__PropertyRule__Group__8"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:872:1: rule__PropertyRule__Group__8 : rule__PropertyRule__Group__8__Impl ;
    public final void rule__PropertyRule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:876:1: ( rule__PropertyRule__Group__8__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:877:2: rule__PropertyRule__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__PropertyRule__Group__8__Impl_in_rule__PropertyRule__Group__81832);
            rule__PropertyRule__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__8"


    // $ANTLR start "rule__PropertyRule__Group__8__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:883:1: rule__PropertyRule__Group__8__Impl : ( ( rule__PropertyRule__DefaultAssignment_8 )? ) ;
    public final void rule__PropertyRule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:887:1: ( ( ( rule__PropertyRule__DefaultAssignment_8 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:888:1: ( ( rule__PropertyRule__DefaultAssignment_8 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:888:1: ( ( rule__PropertyRule__DefaultAssignment_8 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:889:1: ( rule__PropertyRule__DefaultAssignment_8 )?
            {
             before(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_8()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:890:1: ( rule__PropertyRule__DefaultAssignment_8 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==35) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:890:2: rule__PropertyRule__DefaultAssignment_8
                    {
                    pushFollow(FOLLOW_rule__PropertyRule__DefaultAssignment_8_in_rule__PropertyRule__Group__8__Impl1859);
                    rule__PropertyRule__DefaultAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyRuleAccess().getDefaultAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__Group__8__Impl"


    // $ANTLR start "rule__AggregationRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:918:1: rule__AggregationRule__Group__0 : rule__AggregationRule__Group__0__Impl rule__AggregationRule__Group__1 ;
    public final void rule__AggregationRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:922:1: ( rule__AggregationRule__Group__0__Impl rule__AggregationRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:923:2: rule__AggregationRule__Group__0__Impl rule__AggregationRule__Group__1
            {
            pushFollow(FOLLOW_rule__AggregationRule__Group__0__Impl_in_rule__AggregationRule__Group__01908);
            rule__AggregationRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AggregationRule__Group__1_in_rule__AggregationRule__Group__01911);
            rule__AggregationRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AggregationRule__Group__0"


    // $ANTLR start "rule__AggregationRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:930:1: rule__AggregationRule__Group__0__Impl : ( '@' ) ;
    public final void rule__AggregationRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:934:1: ( ( '@' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:935:1: ( '@' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:935:1: ( '@' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:936:1: '@'
            {
             before(grammarAccess.getAggregationRuleAccess().getCommercialAtKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__AggregationRule__Group__0__Impl1939); 
             after(grammarAccess.getAggregationRuleAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AggregationRule__Group__0__Impl"


    // $ANTLR start "rule__AggregationRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:949:1: rule__AggregationRule__Group__1 : rule__AggregationRule__Group__1__Impl ;
    public final void rule__AggregationRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:953:1: ( rule__AggregationRule__Group__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:954:2: rule__AggregationRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AggregationRule__Group__1__Impl_in_rule__AggregationRule__Group__11970);
            rule__AggregationRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AggregationRule__Group__1"


    // $ANTLR start "rule__AggregationRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:960:1: rule__AggregationRule__Group__1__Impl : ( ( rule__AggregationRule__AggregationAssignment_1 ) ) ;
    public final void rule__AggregationRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:964:1: ( ( ( rule__AggregationRule__AggregationAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:965:1: ( ( rule__AggregationRule__AggregationAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:965:1: ( ( rule__AggregationRule__AggregationAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:966:1: ( rule__AggregationRule__AggregationAssignment_1 )
            {
             before(grammarAccess.getAggregationRuleAccess().getAggregationAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:967:1: ( rule__AggregationRule__AggregationAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:967:2: rule__AggregationRule__AggregationAssignment_1
            {
            pushFollow(FOLLOW_rule__AggregationRule__AggregationAssignment_1_in_rule__AggregationRule__Group__1__Impl1997);
            rule__AggregationRule__AggregationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAggregationRuleAccess().getAggregationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AggregationRule__Group__1__Impl"


    // $ANTLR start "rule__TypeRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:981:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:985:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:986:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02031);
            rule__TypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02034);
            rule__TypeRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__Group__0"


    // $ANTLR start "rule__TypeRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:993:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:997:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:998:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:998:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:999:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1000:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==26) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1000:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2061);
                    rule__TypeRule__PathAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__Group__0__Impl"


    // $ANTLR start "rule__TypeRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1010:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1014:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1015:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12092);
            rule__TypeRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__Group__1"


    // $ANTLR start "rule__TypeRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1021:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1025:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1026:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1026:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1027:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1028:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1028:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2119);
            rule__TypeRule__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1042:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1046:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1047:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02153);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02156);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1054:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1058:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1059:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1059:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1060:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1061:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1061:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2183);
            rule__QualifiedName__PathAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1071:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1075:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1076:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12213);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12216);
            rule__QualifiedName__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1083:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1087:1: ( ( '::' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1088:1: ( '::' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1088:1: ( '::' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1089:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__QualifiedName__Group__1__Impl2244); 
             after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1102:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1106:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1107:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22275);
            rule__QualifiedName__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__2"


    // $ANTLR start "rule__QualifiedName__Group__2__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1113:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1117:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1118:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1118:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1119:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1120:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==26) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1120:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2302);
                    rule__QualifiedName__RemainingAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1136:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1140:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1141:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02339);
            rule__MultiplicityRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02342);
            rule__MultiplicityRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__0"


    // $ANTLR start "rule__MultiplicityRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1148:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1152:1: ( ( '[' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1153:1: ( '[' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1153:1: ( '[' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1154:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__MultiplicityRule__Group__0__Impl2370); 
             after(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1167:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1171:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1172:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12401);
            rule__MultiplicityRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12404);
            rule__MultiplicityRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__1"


    // $ANTLR start "rule__MultiplicityRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1179:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1183:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1184:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1184:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1185:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1186:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1186:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2431);
            rule__MultiplicityRule__BoundsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1196:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1200:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1201:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22461);
            rule__MultiplicityRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22464);
            rule__MultiplicityRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__2"


    // $ANTLR start "rule__MultiplicityRule__Group__2__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1208:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1212:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1213:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1213:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1214:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1215:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1215:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2491);
                    rule__MultiplicityRule__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__3"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1225:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1229:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1230:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32522);
            rule__MultiplicityRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__3"


    // $ANTLR start "rule__MultiplicityRule__Group__3__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1236:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1240:1: ( ( ']' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1241:1: ( ']' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1241:1: ( ']' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1242:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__MultiplicityRule__Group__3__Impl2550); 
             after(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group__3__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group_2__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1263:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1267:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1268:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02589);
            rule__MultiplicityRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02592);
            rule__MultiplicityRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group_2__0"


    // $ANTLR start "rule__MultiplicityRule__Group_2__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1275:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1279:1: ( ( '..' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1280:1: ( '..' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1280:1: ( '..' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1281:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,29,FOLLOW_29_in_rule__MultiplicityRule__Group_2__0__Impl2620); 
             after(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group_2__0__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group_2__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1294:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1298:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1299:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12651);
            rule__MultiplicityRule__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group_2__1"


    // $ANTLR start "rule__MultiplicityRule__Group_2__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1305:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1309:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1310:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1310:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1311:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1312:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1312:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2678);
            rule__MultiplicityRule__BoundsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__Group_2__1__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1326:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1330:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1331:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02712);
            rule__ModifiersRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02715);
            rule__ModifiersRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__0"


    // $ANTLR start "rule__ModifiersRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1338:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1342:1: ( ( '{' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1343:1: ( '{' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1343:1: ( '{' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1344:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__ModifiersRule__Group__0__Impl2743); 
             after(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1357:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1361:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1362:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12774);
            rule__ModifiersRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12777);
            rule__ModifiersRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__1"


    // $ANTLR start "rule__ModifiersRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1369:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1373:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1374:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1374:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1375:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1376:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1376:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2804);
            rule__ModifiersRule__ValuesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__1__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1386:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1390:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1391:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22834);
            rule__ModifiersRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22837);
            rule__ModifiersRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__2"


    // $ANTLR start "rule__ModifiersRule__Group__2__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1398:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1402:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1403:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1403:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1404:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1405:1: ( rule__ModifiersRule__Group_2__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==32) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1405:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2864);
            	    rule__ModifiersRule__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getModifiersRuleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__2__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__3"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1415:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1419:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1420:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32895);
            rule__ModifiersRule__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__3"


    // $ANTLR start "rule__ModifiersRule__Group__3__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1426:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1430:1: ( ( '}' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1431:1: ( '}' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1431:1: ( '}' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1432:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__ModifiersRule__Group__3__Impl2923); 
             after(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__3__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1453:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1457:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1458:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02962);
            rule__ModifiersRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02965);
            rule__ModifiersRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group_2__0"


    // $ANTLR start "rule__ModifiersRule__Group_2__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1465:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1469:1: ( ( ',' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1470:1: ( ',' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1470:1: ( ',' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1471:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,32,FOLLOW_32_in_rule__ModifiersRule__Group_2__0__Impl2993); 
             after(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group_2__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1484:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1488:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1489:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__13024);
            rule__ModifiersRule__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group_2__1"


    // $ANTLR start "rule__ModifiersRule__Group_2__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1495:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1499:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1500:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1500:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1501:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1502:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1502:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl3051);
            rule__ModifiersRule__ValuesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group_2__1__Impl"


    // $ANTLR start "rule__RedefinesRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1516:1: rule__RedefinesRule__Group__0 : rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 ;
    public final void rule__RedefinesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1520:1: ( rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1521:2: rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__03085);
            rule__RedefinesRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__03088);
            rule__RedefinesRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__Group__0"


    // $ANTLR start "rule__RedefinesRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1528:1: rule__RedefinesRule__Group__0__Impl : ( 'redefines' ) ;
    public final void rule__RedefinesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1532:1: ( ( 'redefines' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1533:1: ( 'redefines' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1533:1: ( 'redefines' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1534:1: 'redefines'
            {
             before(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__RedefinesRule__Group__0__Impl3116); 
             after(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__Group__0__Impl"


    // $ANTLR start "rule__RedefinesRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1547:1: rule__RedefinesRule__Group__1 : rule__RedefinesRule__Group__1__Impl ;
    public final void rule__RedefinesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1551:1: ( rule__RedefinesRule__Group__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1552:2: rule__RedefinesRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__13147);
            rule__RedefinesRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__Group__1"


    // $ANTLR start "rule__RedefinesRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1558:1: rule__RedefinesRule__Group__1__Impl : ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) ;
    public final void rule__RedefinesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1562:1: ( ( ( rule__RedefinesRule__PropertyAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1563:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1563:1: ( ( rule__RedefinesRule__PropertyAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1564:1: ( rule__RedefinesRule__PropertyAssignment_1 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1565:1: ( rule__RedefinesRule__PropertyAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1565:2: rule__RedefinesRule__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__PropertyAssignment_1_in_rule__RedefinesRule__Group__1__Impl3174);
            rule__RedefinesRule__PropertyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getPropertyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__Group__1__Impl"


    // $ANTLR start "rule__SubsetsRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1579:1: rule__SubsetsRule__Group__0 : rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 ;
    public final void rule__SubsetsRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1583:1: ( rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1584:2: rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__03208);
            rule__SubsetsRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__03211);
            rule__SubsetsRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__Group__0"


    // $ANTLR start "rule__SubsetsRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1591:1: rule__SubsetsRule__Group__0__Impl : ( 'subsets' ) ;
    public final void rule__SubsetsRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1595:1: ( ( 'subsets' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1596:1: ( 'subsets' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1596:1: ( 'subsets' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1597:1: 'subsets'
            {
             before(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__SubsetsRule__Group__0__Impl3239); 
             after(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__Group__0__Impl"


    // $ANTLR start "rule__SubsetsRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1610:1: rule__SubsetsRule__Group__1 : rule__SubsetsRule__Group__1__Impl ;
    public final void rule__SubsetsRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1614:1: ( rule__SubsetsRule__Group__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1615:2: rule__SubsetsRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__13270);
            rule__SubsetsRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__Group__1"


    // $ANTLR start "rule__SubsetsRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1621:1: rule__SubsetsRule__Group__1__Impl : ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) ;
    public final void rule__SubsetsRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1625:1: ( ( ( rule__SubsetsRule__PropertyAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1626:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1626:1: ( ( rule__SubsetsRule__PropertyAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1627:1: ( rule__SubsetsRule__PropertyAssignment_1 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1628:1: ( rule__SubsetsRule__PropertyAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1628:2: rule__SubsetsRule__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__PropertyAssignment_1_in_rule__SubsetsRule__Group__1__Impl3297);
            rule__SubsetsRule__PropertyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getPropertyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__Group__1__Impl"


    // $ANTLR start "rule__DefaultValueRule__Group__0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1642:1: rule__DefaultValueRule__Group__0 : rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 ;
    public final void rule__DefaultValueRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1646:1: ( rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1647:2: rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__03331);
            rule__DefaultValueRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__03334);
            rule__DefaultValueRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__Group__0"


    // $ANTLR start "rule__DefaultValueRule__Group__0__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1654:1: rule__DefaultValueRule__Group__0__Impl : ( '=' ) ;
    public final void rule__DefaultValueRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1658:1: ( ( '=' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1659:1: ( '=' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1659:1: ( '=' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1660:1: '='
            {
             before(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__DefaultValueRule__Group__0__Impl3362); 
             after(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__Group__0__Impl"


    // $ANTLR start "rule__DefaultValueRule__Group__1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1673:1: rule__DefaultValueRule__Group__1 : rule__DefaultValueRule__Group__1__Impl ;
    public final void rule__DefaultValueRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1677:1: ( rule__DefaultValueRule__Group__1__Impl )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1678:2: rule__DefaultValueRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__13393);
            rule__DefaultValueRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__Group__1"


    // $ANTLR start "rule__DefaultValueRule__Group__1__Impl"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1684:1: rule__DefaultValueRule__Group__1__Impl : ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) ;
    public final void rule__DefaultValueRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1688:1: ( ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1689:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1689:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1690:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1691:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1691:2: rule__DefaultValueRule__DefaultAssignment_1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl3420);
            rule__DefaultValueRule__DefaultAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__Group__1__Impl"


    // $ANTLR start "rule__PropertyRule__VisibilityAssignment_0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1706:1: rule__PropertyRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__PropertyRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1710:1: ( ( ruleVisibilityKind ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1711:1: ( ruleVisibilityKind )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1711:1: ( ruleVisibilityKind )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1712:1: ruleVisibilityKind
            {
             before(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_03459);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__VisibilityAssignment_0"


    // $ANTLR start "rule__PropertyRule__IsDerivedAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1721:1: rule__PropertyRule__IsDerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PropertyRule__IsDerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1725:1: ( ( ( '/' ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1726:1: ( ( '/' ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1726:1: ( ( '/' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1727:1: ( '/' )
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1728:1: ( '/' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1729:1: '/'
            {
             before(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 
            match(input,36,FOLLOW_36_in_rule__PropertyRule__IsDerivedAssignment_13495); 
             after(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 

            }

             after(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__IsDerivedAssignment_1"


    // $ANTLR start "rule__PropertyRule__NameAssignment_2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1744:1: rule__PropertyRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PropertyRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1748:1: ( ( RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1749:1: ( RULE_ID )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1749:1: ( RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1750:1: RULE_ID
            {
             before(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_23534); 
             after(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__NameAssignment_2"


    // $ANTLR start "rule__PropertyRule__TypeAssignment_4_0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1759:1: rule__PropertyRule__TypeAssignment_4_0 : ( ruleTypeRule ) ;
    public final void rule__PropertyRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1763:1: ( ( ruleTypeRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1764:1: ( ruleTypeRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1764:1: ( ruleTypeRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1765:1: ruleTypeRule
            {
             before(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_03565);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__TypeAssignment_4_0"


    // $ANTLR start "rule__PropertyRule__MultiplicityAssignment_5"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1774:1: rule__PropertyRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__PropertyRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1778:1: ( ( ruleMultiplicityRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1779:1: ( ruleMultiplicityRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1779:1: ( ruleMultiplicityRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1780:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_53596);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__MultiplicityAssignment_5"


    // $ANTLR start "rule__PropertyRule__ModifiersAssignment_6"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1789:1: rule__PropertyRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__PropertyRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1793:1: ( ( ruleModifiersRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1794:1: ( ruleModifiersRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1794:1: ( ruleModifiersRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1795:1: ruleModifiersRule
            {
             before(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_63627);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__ModifiersAssignment_6"


    // $ANTLR start "rule__PropertyRule__AggregationAssignment_7"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1804:1: rule__PropertyRule__AggregationAssignment_7 : ( ruleAggregationRule ) ;
    public final void rule__PropertyRule__AggregationAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1808:1: ( ( ruleAggregationRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1809:1: ( ruleAggregationRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1809:1: ( ruleAggregationRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1810:1: ruleAggregationRule
            {
             before(grammarAccess.getPropertyRuleAccess().getAggregationAggregationRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleAggregationRule_in_rule__PropertyRule__AggregationAssignment_73658);
            ruleAggregationRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getAggregationAggregationRuleParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__AggregationAssignment_7"


    // $ANTLR start "rule__PropertyRule__DefaultAssignment_8"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1819:1: rule__PropertyRule__DefaultAssignment_8 : ( ruleDefaultValueRule ) ;
    public final void rule__PropertyRule__DefaultAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1823:1: ( ( ruleDefaultValueRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1824:1: ( ruleDefaultValueRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1824:1: ( ruleDefaultValueRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1825:1: ruleDefaultValueRule
            {
             before(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_rule__PropertyRule__DefaultAssignment_83689);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyRule__DefaultAssignment_8"


    // $ANTLR start "rule__AggregationRule__AggregationAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1834:1: rule__AggregationRule__AggregationAssignment_1 : ( ruleAggregationKind ) ;
    public final void rule__AggregationRule__AggregationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1838:1: ( ( ruleAggregationKind ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1839:1: ( ruleAggregationKind )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1839:1: ( ruleAggregationKind )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1840:1: ruleAggregationKind
            {
             before(grammarAccess.getAggregationRuleAccess().getAggregationAggregationKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleAggregationKind_in_rule__AggregationRule__AggregationAssignment_13720);
            ruleAggregationKind();

            state._fsp--;

             after(grammarAccess.getAggregationRuleAccess().getAggregationAggregationKindEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AggregationRule__AggregationAssignment_1"


    // $ANTLR start "rule__TypeRule__PathAssignment_0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1849:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1853:1: ( ( ruleQualifiedName ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1854:1: ( ruleQualifiedName )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1854:1: ( ruleQualifiedName )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1855:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03751);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__PathAssignment_0"


    // $ANTLR start "rule__TypeRule__TypeAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1864:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1868:1: ( ( ( RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1869:1: ( ( RULE_ID ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1869:1: ( ( RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1870:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1871:1: ( RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1872:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13786); 
             after(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRule__TypeAssignment_1"


    // $ANTLR start "rule__QualifiedName__PathAssignment_0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1883:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1887:1: ( ( ( RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1888:1: ( ( RULE_ID ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1888:1: ( ( RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1889:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1890:1: ( RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1891:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03825); 
             after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__PathAssignment_0"


    // $ANTLR start "rule__QualifiedName__RemainingAssignment_2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1902:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1906:1: ( ( ruleQualifiedName ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1907:1: ( ruleQualifiedName )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1907:1: ( ruleQualifiedName )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1908:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23860);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__RemainingAssignment_2"


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1917:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1921:1: ( ( ruleBoundSpecification ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1922:1: ( ruleBoundSpecification )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1922:1: ( ruleBoundSpecification )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1923:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13891);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__BoundsAssignment_1"


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_2_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1932:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1936:1: ( ( ruleBoundSpecification ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1937:1: ( ruleBoundSpecification )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1937:1: ( ruleBoundSpecification )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1938:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13922);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityRule__BoundsAssignment_2_1"


    // $ANTLR start "rule__BoundSpecification__ValueAssignment"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1947:1: rule__BoundSpecification__ValueAssignment : ( ruleUnlimitedLiteral ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1951:1: ( ( ruleUnlimitedLiteral ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1952:1: ( ruleUnlimitedLiteral )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1952:1: ( ruleUnlimitedLiteral )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1953:1: ruleUnlimitedLiteral
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3953);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoundSpecification__ValueAssignment"


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1962:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1966:1: ( ( ruleModifierSpecification ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1967:1: ( ruleModifierSpecification )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1967:1: ( ruleModifierSpecification )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1968:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13984);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__ValuesAssignment_1"


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_2_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1977:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1981:1: ( ( ruleModifierSpecification ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1982:1: ( ruleModifierSpecification )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1982:1: ( ruleModifierSpecification )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1983:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_14015);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__ValuesAssignment_2_1"


    // $ANTLR start "rule__ModifierSpecification__ValueAssignment_0"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1992:1: rule__ModifierSpecification__ValueAssignment_0 : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1996:1: ( ( ruleModifierKind ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1997:1: ( ruleModifierKind )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1997:1: ( ruleModifierKind )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:1998:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_04046);
            ruleModifierKind();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__ValueAssignment_0"


    // $ANTLR start "rule__ModifierSpecification__RedefinesAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2007:1: rule__ModifierSpecification__RedefinesAssignment_1 : ( ruleRedefinesRule ) ;
    public final void rule__ModifierSpecification__RedefinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2011:1: ( ( ruleRedefinesRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2012:1: ( ruleRedefinesRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2012:1: ( ruleRedefinesRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2013:1: ruleRedefinesRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_14077);
            ruleRedefinesRule();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__RedefinesAssignment_1"


    // $ANTLR start "rule__ModifierSpecification__SubsetsAssignment_2"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2022:1: rule__ModifierSpecification__SubsetsAssignment_2 : ( ruleSubsetsRule ) ;
    public final void rule__ModifierSpecification__SubsetsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2026:1: ( ( ruleSubsetsRule ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2027:1: ( ruleSubsetsRule )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2027:1: ( ruleSubsetsRule )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2028:1: ruleSubsetsRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_24108);
            ruleSubsetsRule();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifierSpecification__SubsetsAssignment_2"


    // $ANTLR start "rule__RedefinesRule__PropertyAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2037:1: rule__RedefinesRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RedefinesRule__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2041:1: ( ( ( RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2042:1: ( ( RULE_ID ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2042:1: ( ( RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2043:1: ( RULE_ID )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2044:1: ( RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2045:1: RULE_ID
            {
             before(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RedefinesRule__PropertyAssignment_14143); 
             after(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RedefinesRule__PropertyAssignment_1"


    // $ANTLR start "rule__SubsetsRule__PropertyAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2056:1: rule__SubsetsRule__PropertyAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubsetsRule__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2060:1: ( ( ( RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2061:1: ( ( RULE_ID ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2061:1: ( ( RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2062:1: ( RULE_ID )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2063:1: ( RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2064:1: RULE_ID
            {
             before(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubsetsRule__PropertyAssignment_14182); 
             after(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubsetsRule__PropertyAssignment_1"


    // $ANTLR start "rule__DefaultValueRule__DefaultAssignment_1"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2075:1: rule__DefaultValueRule__DefaultAssignment_1 : ( RULE_STRING ) ;
    public final void rule__DefaultValueRule__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2079:1: ( ( RULE_STRING ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2080:1: ( RULE_STRING )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2080:1: ( RULE_STRING )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext.ui/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/ui/contentassist/antlr/internal/InternalNIEMUmlProperty.g:2081:1: RULE_STRING
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_14217); 
             after(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultValueRule__DefaultAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePropertyRule_in_entryRulePropertyRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0_in_rulePropertyRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregationRule_in_entryRuleAggregationRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAggregationRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AggregationRule__Group__0_in_ruleAggregationRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AggregationKind__Alternatives_in_ruleAggregationKind791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__TypeAssignment_4_0_in_rule__PropertyRule__Alternatives_4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__PropertyRule__Alternatives_4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__UnlimitedLiteral__Alternatives969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AggregationKind__Alternatives1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__AggregationKind__Alternatives1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__AggregationKind__Alternatives1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__VisibilityKind__Alternatives1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__VisibilityKind__Alternatives1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__VisibilityKind__Alternatives1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ModifierKind__Alternatives1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ModifierKind__Alternatives1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ModifierKind__Alternatives1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ModifierKind__Alternatives1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__0__Impl_in_rule__PropertyRule__Group__01346 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1_in_rule__PropertyRule__Group__01349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__VisibilityAssignment_0_in_rule__PropertyRule__Group__0__Impl1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__1__Impl_in_rule__PropertyRule__Group__11406 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2_in_rule__PropertyRule__Group__11409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__IsDerivedAssignment_1_in_rule__PropertyRule__Group__1__Impl1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__2__Impl_in_rule__PropertyRule__Group__21467 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3_in_rule__PropertyRule__Group__21470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__NameAssignment_2_in_rule__PropertyRule__Group__2__Impl1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__3__Impl_in_rule__PropertyRule__Group__31527 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4_in_rule__PropertyRule__Group__31530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__PropertyRule__Group__3__Impl1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__4__Impl_in_rule__PropertyRule__Group__41589 = new BitSet(new long[]{0x000000084A000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5_in_rule__PropertyRule__Group__41592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Alternatives_4_in_rule__PropertyRule__Group__4__Impl1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__5__Impl_in_rule__PropertyRule__Group__51649 = new BitSet(new long[]{0x000000084A000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6_in_rule__PropertyRule__Group__51652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__MultiplicityAssignment_5_in_rule__PropertyRule__Group__5__Impl1679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__6__Impl_in_rule__PropertyRule__Group__61710 = new BitSet(new long[]{0x000000084A000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__7_in_rule__PropertyRule__Group__61713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__ModifiersAssignment_6_in_rule__PropertyRule__Group__6__Impl1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__7__Impl_in_rule__PropertyRule__Group__71771 = new BitSet(new long[]{0x000000084A000000L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__8_in_rule__PropertyRule__Group__71774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__AggregationAssignment_7_in_rule__PropertyRule__Group__7__Impl1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__Group__8__Impl_in_rule__PropertyRule__Group__81832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyRule__DefaultAssignment_8_in_rule__PropertyRule__Group__8__Impl1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AggregationRule__Group__0__Impl_in_rule__AggregationRule__Group__01908 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_rule__AggregationRule__Group__1_in_rule__AggregationRule__Group__01911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__AggregationRule__Group__0__Impl1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AggregationRule__Group__1__Impl_in_rule__AggregationRule__Group__11970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AggregationRule__AggregationAssignment_1_in_rule__AggregationRule__Group__1__Impl1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02031 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02153 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12213 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__QualifiedName__Group__1__Impl2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02339 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MultiplicityRule__Group__0__Impl2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12401 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22461 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__MultiplicityRule__Group__3__Impl2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02589 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MultiplicityRule__Group_2__0__Impl2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__02712 = new BitSet(new long[]{0x0000000600F00000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__02715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ModifiersRule__Group__0__Impl2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__12774 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__12777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__22834 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__22837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl2864 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__32895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ModifiersRule__Group__3__Impl2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__02962 = new BitSet(new long[]{0x0000000600F00000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__02965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ModifiersRule__Group_2__0__Impl2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__13024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__03085 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__03088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__RedefinesRule__Group__0__Impl3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__13147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__PropertyAssignment_1_in_rule__RedefinesRule__Group__1__Impl3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__03208 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__03211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__SubsetsRule__Group__0__Impl3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__13270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__PropertyAssignment_1_in_rule__SubsetsRule__Group__1__Impl3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__03331 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__03334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__DefaultValueRule__Group__0__Impl3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__13393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl3420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__PropertyRule__VisibilityAssignment_03459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PropertyRule__IsDerivedAssignment_13495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyRule__NameAssignment_23534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__PropertyRule__TypeAssignment_4_03565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PropertyRule__MultiplicityAssignment_53596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PropertyRule__ModifiersAssignment_63627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregationRule_in_rule__PropertyRule__AggregationAssignment_73658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rule__PropertyRule__DefaultAssignment_83689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregationKind_in_rule__AggregationRule__AggregationAssignment_13720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAssignment3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_14015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_04046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_14077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_24108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RedefinesRule__PropertyAssignment_14143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubsetsRule__PropertyAssignment_14182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DefaultValueRule__DefaultAssignment_14217 = new BitSet(new long[]{0x0000000000000002L});

}