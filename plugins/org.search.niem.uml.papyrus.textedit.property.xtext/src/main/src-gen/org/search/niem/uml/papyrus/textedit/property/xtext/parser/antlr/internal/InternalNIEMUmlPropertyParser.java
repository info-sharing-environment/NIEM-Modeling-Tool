package org.search.niem.uml.papyrus.textedit.property.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.search.niem.uml.papyrus.textedit.property.xtext.services.NIEMUmlPropertyGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNIEMUmlPropertyParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'<Undefined>'", "'@'", "'::'", "'['", "'..'", "']'", "'*'", "'{'", "','", "'}'", "'redefines'", "'subsets'", "'='", "'none'", "'shared'", "'composite'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_INT=5;
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
    public String getGrammarFileName() { return "../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g"; }



     	private NIEMUmlPropertyGrammarAccess grammarAccess;
     	
        public InternalNIEMUmlPropertyParser(TokenStream input, NIEMUmlPropertyGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PropertyRule";	
       	}
       	
       	@Override
       	protected NIEMUmlPropertyGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePropertyRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:68:1: entryRulePropertyRule returns [EObject current=null] : iv_rulePropertyRule= rulePropertyRule EOF ;
    public final EObject entryRulePropertyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:69:2: (iv_rulePropertyRule= rulePropertyRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:70:2: iv_rulePropertyRule= rulePropertyRule EOF
            {
             newCompositeNode(grammarAccess.getPropertyRuleRule()); 
            pushFollow(FOLLOW_rulePropertyRule_in_entryRulePropertyRule75);
            iv_rulePropertyRule=rulePropertyRule();

            state._fsp--;

             current =iv_rulePropertyRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyRule85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyRule"


    // $ANTLR start "rulePropertyRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:77:1: rulePropertyRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_aggregation_8_0= ruleAggregationRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? ) ;
    public final EObject rulePropertyRule() throws RecognitionException {
        EObject current = null;

        Token lv_isDerived_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_multiplicity_6_0 = null;

        EObject lv_modifiers_7_0 = null;

        EObject lv_aggregation_8_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:80:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_aggregation_8_0= ruleAggregationRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_aggregation_8_0= ruleAggregationRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_aggregation_8_0= ruleAggregationRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_aggregation_8_0= ruleAggregationRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )?
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:83:3: lv_visibility_0_0= ruleVisibilityKind
            {
             
            	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVisibilityKind_in_rulePropertyRule131);
            lv_visibility_0_0=ruleVisibilityKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
            	        }
                   		set(
                   			current, 
                   			"visibility",
                    		lv_visibility_0_0, 
                    		"VisibilityKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:99:2: ( (lv_isDerived_1_0= '/' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:100:1: (lv_isDerived_1_0= '/' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:100:1: (lv_isDerived_1_0= '/' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:101:3: lv_isDerived_1_0= '/'
                    {
                    lv_isDerived_1_0=(Token)match(input,11,FOLLOW_11_in_rulePropertyRule149); 

                            newLeafNode(lv_isDerived_1_0, grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPropertyRuleRule());
                    	        }
                           		setWithLastConsumed(current, "isDerived", lv_isDerived_1_0, "/");
                    	    

                    }


                    }
                    break;

            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:114:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:115:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:115:1: (lv_name_2_0= RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:116:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyRule180); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_rulePropertyRule197); 

                	newLeafNode(otherlv_3, grammarAccess.getPropertyRuleAccess().getColonKeyword_3());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:136:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:136:2: ( (lv_type_4_0= ruleTypeRule ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:136:2: ( (lv_type_4_0= ruleTypeRule ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:137:1: (lv_type_4_0= ruleTypeRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:137:1: (lv_type_4_0= ruleTypeRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:138:3: lv_type_4_0= ruleTypeRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRule_in_rulePropertyRule219);
                    lv_type_4_0=ruleTypeRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"TypeRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:155:7: otherlv_5= '<Undefined>'
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_rulePropertyRule237); 

                        	newLeafNode(otherlv_5, grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1());
                        

                    }
                    break;

            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:159:2: ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:160:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:160:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:161:3: lv_multiplicity_6_0= ruleMultiplicityRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityRule_in_rulePropertyRule259);
                    lv_multiplicity_6_0=ruleMultiplicityRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_6_0, 
                            		"MultiplicityRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:177:3: ( (lv_modifiers_7_0= ruleModifiersRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:178:1: (lv_modifiers_7_0= ruleModifiersRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:178:1: (lv_modifiers_7_0= ruleModifiersRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:179:3: lv_modifiers_7_0= ruleModifiersRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifiersRule_in_rulePropertyRule281);
                    lv_modifiers_7_0=ruleModifiersRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"modifiers",
                            		lv_modifiers_7_0, 
                            		"ModifiersRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:195:3: ( (lv_aggregation_8_0= ruleAggregationRule ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:196:1: (lv_aggregation_8_0= ruleAggregationRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:196:1: (lv_aggregation_8_0= ruleAggregationRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:197:3: lv_aggregation_8_0= ruleAggregationRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getAggregationAggregationRuleParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAggregationRule_in_rulePropertyRule303);
                    lv_aggregation_8_0=ruleAggregationRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"aggregation",
                            		lv_aggregation_8_0, 
                            		"AggregationRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:213:3: ( (lv_default_9_0= ruleDefaultValueRule ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:214:1: (lv_default_9_0= ruleDefaultValueRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:214:1: (lv_default_9_0= ruleDefaultValueRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:215:3: lv_default_9_0= ruleDefaultValueRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_8_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDefaultValueRule_in_rulePropertyRule325);
                    lv_default_9_0=ruleDefaultValueRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"default",
                            		lv_default_9_0, 
                            		"DefaultValueRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyRule"


    // $ANTLR start "entryRuleAggregationRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:239:1: entryRuleAggregationRule returns [EObject current=null] : iv_ruleAggregationRule= ruleAggregationRule EOF ;
    public final EObject entryRuleAggregationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregationRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:240:2: (iv_ruleAggregationRule= ruleAggregationRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:241:2: iv_ruleAggregationRule= ruleAggregationRule EOF
            {
             newCompositeNode(grammarAccess.getAggregationRuleRule()); 
            pushFollow(FOLLOW_ruleAggregationRule_in_entryRuleAggregationRule362);
            iv_ruleAggregationRule=ruleAggregationRule();

            state._fsp--;

             current =iv_ruleAggregationRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAggregationRule372); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAggregationRule"


    // $ANTLR start "ruleAggregationRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:248:1: ruleAggregationRule returns [EObject current=null] : (otherlv_0= '@' ( (lv_aggregation_1_0= ruleAggregationKind ) ) ) ;
    public final EObject ruleAggregationRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_aggregation_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:251:28: ( (otherlv_0= '@' ( (lv_aggregation_1_0= ruleAggregationKind ) ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:252:1: (otherlv_0= '@' ( (lv_aggregation_1_0= ruleAggregationKind ) ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:252:1: (otherlv_0= '@' ( (lv_aggregation_1_0= ruleAggregationKind ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:252:3: otherlv_0= '@' ( (lv_aggregation_1_0= ruleAggregationKind ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleAggregationRule409); 

                	newLeafNode(otherlv_0, grammarAccess.getAggregationRuleAccess().getCommercialAtKeyword_0());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:256:1: ( (lv_aggregation_1_0= ruleAggregationKind ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:257:1: (lv_aggregation_1_0= ruleAggregationKind )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:257:1: (lv_aggregation_1_0= ruleAggregationKind )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:258:3: lv_aggregation_1_0= ruleAggregationKind
            {
             
            	        newCompositeNode(grammarAccess.getAggregationRuleAccess().getAggregationAggregationKindEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAggregationKind_in_ruleAggregationRule430);
            lv_aggregation_1_0=ruleAggregationKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAggregationRuleRule());
            	        }
                   		set(
                   			current, 
                   			"aggregation",
                    		lv_aggregation_1_0, 
                    		"AggregationKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregationRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:282:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:283:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:284:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             newCompositeNode(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule466);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule476); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:291:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:294:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:295:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:295:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:295:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:295:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==15) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:296:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:296:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:297:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule522);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:313:3: ( (otherlv_1= RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:314:1: (otherlv_1= RULE_ID )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:314:1: (otherlv_1= RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:315:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule543); 

            		newLeafNode(otherlv_1, grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:334:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:335:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:336:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName579);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName589); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:343:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:346:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:347:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:347:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:347:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:347:2: ( (otherlv_0= RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:348:1: (otherlv_0= RULE_ID )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:348:1: (otherlv_0= RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:349:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName634); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleQualifiedName646); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:364:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==15) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:365:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:365:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:366:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName667);
                    lv_remaining_2_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                    	        }
                           		set(
                           			current, 
                           			"remaining",
                            		lv_remaining_2_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:390:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:391:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:392:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule704);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();

            state._fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule714); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityRule"


    // $ANTLR start "ruleMultiplicityRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:399:1: ruleMultiplicityRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:402:28: ( (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:403:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:403:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:403:3: otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleMultiplicityRule751); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:407:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:408:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:408:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:409:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule772);
            lv_bounds_1_0=ruleBoundSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
            	        }
                   		add(
                   			current, 
                   			"bounds",
                    		lv_bounds_1_0, 
                    		"BoundSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:425:2: (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:425:4: otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleMultiplicityRule785); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0());
                        
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:429:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:430:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:430:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:431:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule806);
                    lv_bounds_3_0=ruleBoundSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
                    	        }
                           		add(
                           			current, 
                           			"bounds",
                            		lv_bounds_3_0, 
                            		"BoundSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleMultiplicityRule820); 

                	newLeafNode(otherlv_4, grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityRule"


    // $ANTLR start "entryRuleBoundSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:459:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:460:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:461:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             newCompositeNode(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification856);
            iv_ruleBoundSpecification=ruleBoundSpecification();

            state._fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification866); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundSpecification"


    // $ANTLR start "ruleBoundSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:468:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleUnlimitedLiteral ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:471:28: ( ( (lv_value_0_0= ruleUnlimitedLiteral ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:472:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:472:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:473:1: (lv_value_0_0= ruleUnlimitedLiteral )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:473:1: (lv_value_0_0= ruleUnlimitedLiteral )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:474:3: lv_value_0_0= ruleUnlimitedLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification911);
            lv_value_0_0=ruleUnlimitedLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"UnlimitedLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundSpecification"


    // $ANTLR start "entryRuleUnlimitedLiteral"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:498:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
    public final String entryRuleUnlimitedLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:499:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:500:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral947);
            iv_ruleUnlimitedLiteral=ruleUnlimitedLiteral();

            state._fsp--;

             current =iv_ruleUnlimitedLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral958); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnlimitedLiteral"


    // $ANTLR start "ruleUnlimitedLiteral"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:507:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:510:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:511:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:511:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:511:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUnlimitedLiteral998); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:520:2: kw= '*'
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleUnlimitedLiteral1022); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnlimitedLiteral"


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:533:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:534:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:535:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             newCompositeNode(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule1062);
            iv_ruleModifiersRule=ruleModifiersRule();

            state._fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule1072); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifiersRule"


    // $ANTLR start "ruleModifiersRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:542:1: ruleModifiersRule returns [EObject current=null] : (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:545:28: ( (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:546:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:546:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:546:3: otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleModifiersRule1109); 

                	newLeafNode(otherlv_0, grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:550:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:551:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:551:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:552:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1130);
            lv_values_1_0=ruleModifierSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_1_0, 
                    		"ModifierSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:568:2: (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:568:4: otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleModifiersRule1143); 

            	        	newLeafNode(otherlv_2, grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:572:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:573:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:573:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:574:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1164);
            	    lv_values_3_0=ruleModifierSpecification();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_3_0, 
            	            		"ModifierSpecification");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleModifiersRule1178); 

                	newLeafNode(otherlv_4, grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifiersRule"


    // $ANTLR start "entryRuleModifierSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:602:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:603:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:604:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             newCompositeNode(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification1214);
            iv_ruleModifierSpecification=ruleModifierSpecification();

            state._fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification1224); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifierSpecification"


    // $ANTLR start "ruleModifierSpecification"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:611:1: ruleModifierSpecification returns [EObject current=null] : ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;

        EObject lv_redefines_1_0 = null;

        EObject lv_subsets_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:614:28: ( ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:615:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:615:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 33:
            case 34:
            case 35:
            case 36:
                {
                alt12=1;
                }
                break;
            case 23:
                {
                alt12=2;
                }
                break;
            case 24:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:615:2: ( (lv_value_0_0= ruleModifierKind ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:615:2: ( (lv_value_0_0= ruleModifierKind ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:616:1: (lv_value_0_0= ruleModifierKind )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:616:1: (lv_value_0_0= ruleModifierKind )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:617:3: lv_value_0_0= ruleModifierKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification1270);
                    lv_value_0_0=ruleModifierKind();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_0_0, 
                            		"ModifierKind");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:634:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:634:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:635:1: (lv_redefines_1_0= ruleRedefinesRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:635:1: (lv_redefines_1_0= ruleRedefinesRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:636:3: lv_redefines_1_0= ruleRedefinesRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1297);
                    lv_redefines_1_0=ruleRedefinesRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"redefines",
                            		lv_redefines_1_0, 
                            		"RedefinesRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:653:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:653:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:654:1: (lv_subsets_2_0= ruleSubsetsRule )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:654:1: (lv_subsets_2_0= ruleSubsetsRule )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:655:3: lv_subsets_2_0= ruleSubsetsRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1324);
                    lv_subsets_2_0=ruleSubsetsRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"subsets",
                            		lv_subsets_2_0, 
                            		"SubsetsRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifierSpecification"


    // $ANTLR start "entryRuleRedefinesRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:679:1: entryRuleRedefinesRule returns [EObject current=null] : iv_ruleRedefinesRule= ruleRedefinesRule EOF ;
    public final EObject entryRuleRedefinesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRedefinesRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:680:2: (iv_ruleRedefinesRule= ruleRedefinesRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:681:2: iv_ruleRedefinesRule= ruleRedefinesRule EOF
            {
             newCompositeNode(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1360);
            iv_ruleRedefinesRule=ruleRedefinesRule();

            state._fsp--;

             current =iv_ruleRedefinesRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule1370); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRedefinesRule"


    // $ANTLR start "ruleRedefinesRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:688:1: ruleRedefinesRule returns [EObject current=null] : (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRedefinesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:691:28: ( (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:692:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:692:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:692:3: otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleRedefinesRule1407); 

                	newLeafNode(otherlv_0, grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:696:1: ( (otherlv_1= RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:697:1: (otherlv_1= RULE_ID )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:697:1: (otherlv_1= RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:698:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRedefinesRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRedefinesRule1427); 

            		newLeafNode(otherlv_1, grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRedefinesRule"


    // $ANTLR start "entryRuleSubsetsRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:717:1: entryRuleSubsetsRule returns [EObject current=null] : iv_ruleSubsetsRule= ruleSubsetsRule EOF ;
    public final EObject entryRuleSubsetsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubsetsRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:718:2: (iv_ruleSubsetsRule= ruleSubsetsRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:719:2: iv_ruleSubsetsRule= ruleSubsetsRule EOF
            {
             newCompositeNode(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1463);
            iv_ruleSubsetsRule=ruleSubsetsRule();

            state._fsp--;

             current =iv_ruleSubsetsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule1473); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubsetsRule"


    // $ANTLR start "ruleSubsetsRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:726:1: ruleSubsetsRule returns [EObject current=null] : (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleSubsetsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:729:28: ( (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:730:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:730:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:730:3: otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleSubsetsRule1510); 

                	newLeafNode(otherlv_0, grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:734:1: ( (otherlv_1= RULE_ID ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:735:1: (otherlv_1= RULE_ID )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:735:1: (otherlv_1= RULE_ID )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:736:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubsetsRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubsetsRule1530); 

            		newLeafNode(otherlv_1, grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubsetsRule"


    // $ANTLR start "entryRuleDefaultValueRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:755:1: entryRuleDefaultValueRule returns [EObject current=null] : iv_ruleDefaultValueRule= ruleDefaultValueRule EOF ;
    public final EObject entryRuleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultValueRule = null;


        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:756:2: (iv_ruleDefaultValueRule= ruleDefaultValueRule EOF )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:757:2: iv_ruleDefaultValueRule= ruleDefaultValueRule EOF
            {
             newCompositeNode(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1566);
            iv_ruleDefaultValueRule=ruleDefaultValueRule();

            state._fsp--;

             current =iv_ruleDefaultValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule1576); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultValueRule"


    // $ANTLR start "ruleDefaultValueRule"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:764:1: ruleDefaultValueRule returns [EObject current=null] : (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_default_1_0=null;

         enterRule(); 
            
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:767:28: ( (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:768:1: (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:768:1: (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:768:3: otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleDefaultValueRule1613); 

                	newLeafNode(otherlv_0, grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());
                
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:772:1: ( (lv_default_1_0= RULE_STRING ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:773:1: (lv_default_1_0= RULE_STRING )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:773:1: (lv_default_1_0= RULE_STRING )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:774:3: lv_default_1_0= RULE_STRING
            {
            lv_default_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDefaultValueRule1630); 

            			newLeafNode(lv_default_1_0, grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefaultValueRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"default",
                    		lv_default_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultValueRule"


    // $ANTLR start "ruleAggregationKind"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:798:1: ruleAggregationKind returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'shared' ) | (enumLiteral_2= 'composite' ) ) ;
    public final Enumerator ruleAggregationKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:800:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'shared' ) | (enumLiteral_2= 'composite' ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:801:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'shared' ) | (enumLiteral_2= 'composite' ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:801:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'shared' ) | (enumLiteral_2= 'composite' ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt13=1;
                }
                break;
            case 27:
                {
                alt13=2;
                }
                break;
            case 28:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:801:2: (enumLiteral_0= 'none' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:801:2: (enumLiteral_0= 'none' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:801:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleAggregationKind1685); 

                            current = grammarAccess.getAggregationKindAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAggregationKindAccess().getNoneEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:807:6: (enumLiteral_1= 'shared' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:807:6: (enumLiteral_1= 'shared' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:807:8: enumLiteral_1= 'shared'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_27_in_ruleAggregationKind1702); 

                            current = grammarAccess.getAggregationKindAccess().getSharedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAggregationKindAccess().getSharedEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:813:6: (enumLiteral_2= 'composite' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:813:6: (enumLiteral_2= 'composite' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:813:8: enumLiteral_2= 'composite'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleAggregationKind1719); 

                            current = grammarAccess.getAggregationKindAccess().getCompositeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAggregationKindAccess().getCompositeEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregationKind"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:823:1: ruleVisibilityKind returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:825:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:826:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:826:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt14=1;
                }
                break;
            case 30:
                {
                alt14=2;
                }
                break;
            case 31:
                {
                alt14=3;
                }
                break;
            case 32:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:826:2: (enumLiteral_0= '+' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:826:2: (enumLiteral_0= '+' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:826:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_29_in_ruleVisibilityKind1764); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:832:6: (enumLiteral_1= '-' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:832:6: (enumLiteral_1= '-' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:832:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_30_in_ruleVisibilityKind1781); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:838:6: (enumLiteral_2= '#' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:838:6: (enumLiteral_2= '#' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:838:8: enumLiteral_2= '#'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_31_in_ruleVisibilityKind1798); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:844:6: (enumLiteral_3= '~' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:844:6: (enumLiteral_3= '~' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:844:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_32_in_ruleVisibilityKind1815); 

                            current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisibilityKind"


    // $ANTLR start "ruleModifierKind"
    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:854:1: ruleModifierKind returns [Enumerator current=null] : ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:856:28: ( ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) )
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:857:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            {
            // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:857:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt15=1;
                }
                break;
            case 34:
                {
                alt15=2;
                }
                break;
            case 35:
                {
                alt15=3;
                }
                break;
            case 36:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:857:2: (enumLiteral_0= 'readOnly' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:857:2: (enumLiteral_0= 'readOnly' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:857:4: enumLiteral_0= 'readOnly'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_33_in_ruleModifierKind1860); 

                            current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:863:6: (enumLiteral_1= 'union' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:863:6: (enumLiteral_1= 'union' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:863:8: enumLiteral_1= 'union'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_34_in_ruleModifierKind1877); 

                            current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:869:6: (enumLiteral_2= 'ordered' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:869:6: (enumLiteral_2= 'ordered' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:869:8: enumLiteral_2= 'ordered'
                    {
                    enumLiteral_2=(Token)match(input,35,FOLLOW_35_in_ruleModifierKind1894); 

                            current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:875:6: (enumLiteral_3= 'unique' )
                    {
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:875:6: (enumLiteral_3= 'unique' )
                    // ../org.search.niem.uml.papyrus.textedit.property.xtext/src/main/src-gen/org/search/niem/uml/papyrus/textedit/property/xtext/parser/antlr/internal/InternalNIEMUmlProperty.g:875:8: enumLiteral_3= 'unique'
                    {
                    enumLiteral_3=(Token)match(input,36,FOLLOW_36_in_ruleModifierKind1911); 

                            current = grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifierKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePropertyRule_in_entryRulePropertyRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rulePropertyRule131 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_rulePropertyRule149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyRule180 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePropertyRule197 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rulePropertyRule219 = new BitSet(new long[]{0x0000000002114002L});
    public static final BitSet FOLLOW_13_in_rulePropertyRule237 = new BitSet(new long[]{0x0000000002114002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rulePropertyRule259 = new BitSet(new long[]{0x0000000002104002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rulePropertyRule281 = new BitSet(new long[]{0x0000000002004002L});
    public static final BitSet FOLLOW_ruleAggregationRule_in_rulePropertyRule303 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rulePropertyRule325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregationRule_in_entryRuleAggregationRule362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAggregationRule372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleAggregationRule409 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_ruleAggregationKind_in_ruleAggregationRule430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName634 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleQualifiedName646 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicityRule751 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule772 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleMultiplicityRule785 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule806 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMultiplicityRule820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUnlimitedLiteral998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleUnlimitedLiteral1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule1062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleModifiersRule1109 = new BitSet(new long[]{0x0000001E01800000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1130 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleModifiersRule1143 = new BitSet(new long[]{0x0000001E01800000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1164 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleModifiersRule1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification1214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleRedefinesRule1407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRedefinesRule1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleSubsetsRule1510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubsetsRule1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleDefaultValueRule1613 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDefaultValueRule1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAggregationKind1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAggregationKind1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAggregationKind1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVisibilityKind1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVisibilityKind1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVisibilityKind1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVisibilityKind1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleModifierKind1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleModifierKind1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleModifierKind1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleModifierKind1911 = new BitSet(new long[]{0x0000000000000002L});

}