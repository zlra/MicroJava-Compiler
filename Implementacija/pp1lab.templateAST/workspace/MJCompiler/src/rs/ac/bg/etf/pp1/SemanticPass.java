package rs.ac.bg.etf.pp1;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sun.org.apache.xpath.internal.Arg;

import rs.ac.bg.etf.pp1.ast.VoidType;
import rs.ac.bg.etf.pp1.ast.ActPars;
import rs.ac.bg.etf.pp1.ast.ActParsDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.ArrayOrClassName;
import rs.ac.bg.etf.pp1.ast.BreakStm;
import rs.ac.bg.etf.pp1.ast.CondTerm;
import rs.ac.bg.etf.pp1.ast.Condition;
import rs.ac.bg.etf.pp1.ast.ConstElementBoolean;
import rs.ac.bg.etf.pp1.ast.ConstElementChar;
import rs.ac.bg.etf.pp1.ast.ConstElementInteger;
import rs.ac.bg.etf.pp1.ast.DecDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.DeclarationList;
import rs.ac.bg.etf.pp1.ast.DeclarationListEmpty;
import rs.ac.bg.etf.pp1.ast.DeclarationListNotEmpty;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorAllList;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayOrClass;
import rs.ac.bg.etf.pp1.ast.DesignatorAssignExpress;
import rs.ac.bg.etf.pp1.ast.DesignatorElement;
import rs.ac.bg.etf.pp1.ast.DesignatorElementExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorElementIdent;
import rs.ac.bg.etf.pp1.ast.DesignatorIdent;
import rs.ac.bg.etf.pp1.ast.DesignatorList;
import rs.ac.bg.etf.pp1.ast.DoStatement;
import rs.ac.bg.etf.pp1.ast.EmptyReturnStatement;
import rs.ac.bg.etf.pp1.ast.EqRelop;
import rs.ac.bg.etf.pp1.ast.ExistingActPars;
import rs.ac.bg.etf.pp1.ast.ExistingDesignatorListMulti;
import rs.ac.bg.etf.pp1.ast.ExistingDesignatorListSingle;
import rs.ac.bg.etf.pp1.ast.ExistingFormPars;
import rs.ac.bg.etf.pp1.ast.ExistingMethodDeclarationList;
import rs.ac.bg.etf.pp1.ast.ExistingOptionalMinus;
import rs.ac.bg.etf.pp1.ast.ExistingSquareBrackets;
import rs.ac.bg.etf.pp1.ast.Expression;
import rs.ac.bg.etf.pp1.ast.ExpressionList;
import rs.ac.bg.etf.pp1.ast.FactorBoolConst;
import rs.ac.bg.etf.pp1.ast.FactorBracketExpression;
import rs.ac.bg.etf.pp1.ast.FactorCharConst;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorNewTypeWithExpr;
import rs.ac.bg.etf.pp1.ast.FactorNumConst;
import rs.ac.bg.etf.pp1.ast.FormPar;
import rs.ac.bg.etf.pp1.ast.FormParamNoErr;
import rs.ac.bg.etf.pp1.ast.FormPars;
import rs.ac.bg.etf.pp1.ast.IfCond;
import rs.ac.bg.etf.pp1.ast.IfStm;
import rs.ac.bg.etf.pp1.ast.IncDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.MethodDeclaration;
import rs.ac.bg.etf.pp1.ast.MethodDeclarationList;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.MinusAddOp;
import rs.ac.bg.etf.pp1.ast.MulOpMultiply;
import rs.ac.bg.etf.pp1.ast.MultiActPars;
import rs.ac.bg.etf.pp1.ast.MultiCondFact;
import rs.ac.bg.etf.pp1.ast.MultiCondFactList;
import rs.ac.bg.etf.pp1.ast.MultiCondTermList;
import rs.ac.bg.etf.pp1.ast.MultiConstAssignList;
import rs.ac.bg.etf.pp1.ast.MultiExpressionlist;
import rs.ac.bg.etf.pp1.ast.MultiFormPars;
import rs.ac.bg.etf.pp1.ast.NeqRelop;
import rs.ac.bg.etf.pp1.ast.NonEmptyReturnStatement;
import rs.ac.bg.etf.pp1.ast.NonExistingActPars;
import rs.ac.bg.etf.pp1.ast.NonExistingFormPars;
import rs.ac.bg.etf.pp1.ast.NonExistingMethodDeclarationList;
import rs.ac.bg.etf.pp1.ast.NonExistingOptionalMinus;
import rs.ac.bg.etf.pp1.ast.NonExistingSquareBrackets;
import rs.ac.bg.etf.pp1.ast.NotVoid;
import rs.ac.bg.etf.pp1.ast.OptionalFormPars;
import rs.ac.bg.etf.pp1.ast.OptionalOptionalActParsExist;
import rs.ac.bg.etf.pp1.ast.OptionalOptionalActParsNotExist;
import rs.ac.bg.etf.pp1.ast.PrintStatementWithNumConst;
import rs.ac.bg.etf.pp1.ast.PrintStatementWithoutNumConst;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.ProgramName;
import rs.ac.bg.etf.pp1.ast.ReadSt;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.ReadStm;
import rs.ac.bg.etf.pp1.ast.SingleActPars;
import rs.ac.bg.etf.pp1.ast.SingleCondFact;
import rs.ac.bg.etf.pp1.ast.SingleCondFactList;
import rs.ac.bg.etf.pp1.ast.SingleCondTermList;
import rs.ac.bg.etf.pp1.ast.SingleConstAssignList;
import rs.ac.bg.etf.pp1.ast.SingleExpressionList;
import rs.ac.bg.etf.pp1.ast.SingleFormPars;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.TermMultiFactor;
import rs.ac.bg.etf.pp1.ast.TermSingleFactor;
import rs.ac.bg.etf.pp1.ast.Type;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VarDeclarationElem;
import rs.ac.bg.etf.pp1.ast.VarDeclarationElement;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	{
		Tab.insert(Obj.Type, "bool" , new Struct(Struct.Bool));
	}
	
	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	int nVars;
	
	
	//za metode 
	boolean currentMethodIsVoid = false; 
	boolean currentMethodHasArguments = false;
	boolean mainMethodFound = false; 
	Struct currentMethodType = null; 
	boolean returnFound = false; 
	boolean returnIsEmpty = false; 
	boolean closingScopeIsOk = true; 
	
	//za konstante 
	Struct currentConstVarType = null;
	
	//za varijable
	boolean variableIsArray = false;
	
	//za designator
	boolean isIdent = false;
	boolean needsToBeIntBecauseOfMinus = false; 
	String currentArrayOrClassName = ""; 
	
	boolean readDesignatorArrayElement = false;
	boolean isReadStatement = false;
	
	List<Obj> listOfFormalParameters = new ArrayList<Obj>();
    

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
		
		if (!mainMethodFound)
			report_error("Greska na liniji " + program.getLine() + ": Main metoda nije nadjena.", null);
	}
	
	public void visit(ProgramName programName) {
		programName.obj = Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
		Tab.openScope(); 
		
		Obj ord = Tab.insert(Obj.Meth, "ord", Tab.intType);
		Obj chr = Tab.insert(Obj.Meth, "chr", Tab.charType);
		Obj len = Tab.insert(Obj.Meth, "len", Tab.intType);
		
		ord.setLevel(1);
		chr.setLevel(1);
		len.setLevel(1);
	}
	
	public void visit(DeclarationListNotEmpty declarationList) {
		
	}
	
	public void visit(DeclarationListEmpty declarationList) {
		
	}
	
	public void visit(ExistingMethodDeclarationList declarationList) {
	
	}	
	
	public void visit(NonExistingMethodDeclarationList declarationList) {
	
	}
	
	public void visit(MethodName methodName) {
		Obj alreadyExists = Tab.currentScope.findSymbol(methodName.getMethodName());
			
		if (alreadyExists != null) {
			report_error("Greska na liniji " + methodName.getLine() + ": Objekat vec postoji u tabeli simbola",null);
			closingScopeIsOk = false; 
		} else {
			methodName.obj = Tab.insert(Obj.Meth, methodName.getMethodName(), currentMethodType);
			Tab.openScope();
			closingScopeIsOk = true; 
		}
	}
	
	
	
	public void visit(MethodDeclaration methodDeclaration) {
		String methodName = methodDeclaration.getMethodName().getMethodName();
		
		if (methodDeclaration.getMethodName().getMethodName().equals("main")) {
			mainMethodFound = true;
			
			if (currentMethodIsVoid == false)
			{
				report_error("Main metoda nije void.Greska na liniji " + methodDeclaration.getLine(),null);
			}
			else
			{
				if (currentMethodHasArguments)
				{
					report_error("Main metoda ima argumente.Greska na liniji " + methodDeclaration.getLine(),null);
				} 
				else
				{
					if (closingScopeIsOk == true) {
						Tab.chainLocalSymbols(methodDeclaration.getMethodName().obj);
						Tab.closeScope();
					}
				}
			}
		} else {
			if (currentMethodType != Tab.noType && returnFound == false) {
				//proveri expression - kompatibilnost tipova
				report_info("Greska na liniji " + methodDeclaration.getLine() + ": Metoda nije void a ne postoji return naredba",null);
			} else {
				if (closingScopeIsOk == true) {
					Tab.chainLocalSymbols(methodDeclaration.getMethodName().obj);
					Tab.closeScope();
				}
			}
		}
		
		listOfFormalParameters = new ArrayList<Obj>();
		returnFound = false; 
		currentMethodType = null;
		currentMethodHasArguments = false;
		currentMethodIsVoid = false; 
	}
	
	public void visit(ExistingFormPars existingFormPars) {
		currentMethodHasArguments = true;
	}
	
	public void visit(NonExistingFormPars nonExistingFormPars) {
		currentMethodHasArguments = false;
	}
	
	public void visit(VoidType voidType) {
		currentMethodIsVoid = true;
		currentMethodType = Tab.noType;
	}
	
	public void visit(NotVoid notVoidType) {
		currentMethodIsVoid = false;
		currentMethodType = Tab.find(notVoidType.getType().getTypeName()).getType();
	}
	
	public void visit(Type typeObject) {
		Obj type = Tab.find(typeObject.getTypeName());
		
		if (type == Tab.noObj)
		{
			report_error("Greska na liniji " + typeObject.getLine() + ": Tip " + typeObject.getTypeName() + " ne postoji u tabeli simbola", null);
		}
		else
		{
			if (type.getKind() != Obj.Type)
				report_error("Greska na liniji " + typeObject.getLine() + ": " + typeObject.getTypeName() + " nije tip", null);
			
			typeObject.struct = currentConstVarType = type.getType();	
		}
	}
	
	public void visit(SingleConstAssignList scal) {
		if (Tab.find(scal.getConstantName()) != Tab.noObj) {
			report_error("Greska na liniji " + scal.getLine() + ": Identifikator konstante vec postoji u tabeli simbola", null);
		} else {
			scal.obj = Tab.insert(Obj.Con, scal.getConstantName() , currentConstVarType);
			
			if (currentConstVarType == Tab.intType)
			{
				if (scal.getConstElement() instanceof ConstElementInteger) {
				int adr = ((ConstElementInteger) scal.getConstElement()).getN1().intValue();
				scal.obj.setAdr(adr);
				} else { report_error("Greska na liniji " + scal.getLine() + " razliciti tipovi pri dodeli vrednosti konstanti",null);}			
			}
			if (currentConstVarType == Tab.charType)
			{
				if (scal.getConstElement() instanceof ConstElementChar) {
				char adr = ((ConstElementChar) scal.getConstElement()).getC1().charAt(0);
				scal.obj.setAdr(adr);
				} else { report_error("Greska na liniji " + scal.getLine() + " razliciti tipovi pri dodeli vrednosti konstanti",null);}
			}
			if (currentConstVarType == Tab.find("bool").getType())
			{
				if (scal.getConstElement() instanceof ConstElementBoolean) {
				boolean flag = ((ConstElementBoolean) scal.getConstElement()).getB1();
				int adr = (flag == true) ? 1 : 0;
				scal.obj.setAdr(adr);
				} else {report_error("Greska na liniji " + scal.getLine() + " razliciti tipovi pri dodeli vrednosti konstanti",null);}
			}
		}
	}
	
	public void visit(MultiConstAssignList mcas) {
		if (Tab.find(mcas.getConstantName()) != Tab.noObj) {
			report_error("Greska na liniji " + mcas.getLine() + ": Identifikator konstante vec postoji u tabeli simbola", null);
		} else {
			mcas.obj = Tab.insert(Obj.Con, mcas.getConstantName() , currentConstVarType);
			if (currentConstVarType == Tab.intType)
			{
				int adr = ((ConstElementInteger) mcas.getConstElement()).getN1().intValue();
				mcas.obj.setAdr(adr);
			}
			if (currentConstVarType == Tab.charType)
			{
				char adr = ((ConstElementChar) mcas.getConstElement()).getC1().charAt(1);
				mcas.obj.setAdr(adr);
			}
			if (currentConstVarType == Tab.find("bool").getType())
			{
				boolean flag = ((ConstElementBoolean) mcas.getConstElement()).getB1();
				int adr = (flag == true) ? 1 : 0;
				mcas.obj.setAdr(adr);
			}
		}
	}
	
	
	public void visit(ConstElementInteger elemInteger){
		elemInteger.struct = Tab.intType;
		if (currentConstVarType != Tab.intType)
			report_error("Greska na liniji " + elemInteger.getLine() + ": Pogresan tip pri dodeli vrednosti konstanti.",null);
	}
	
	public void visit(ConstElementBoolean elemBool) {
		elemBool.struct = Tab.find("bool").getType();
		if (currentConstVarType != Tab.find("bool").getType())
			report_error("Greska na liniji " + elemBool.getLine() + ": Pogresan tip pri dodeli vrednosti konstanti.",null);
	}
	
	public void visit(ConstElementChar elemChar) {
		elemChar.struct = Tab.charType;
		if (currentConstVarType != Tab.charType)
			report_error("Greska na liniji " + elemChar.getLine() + ": Pogresan tip pri dodeli vrednosti konstanti.",null);
	}
	
	public void visit(EmptyReturnStatement ers) {
		returnFound = true; 
	    returnIsEmpty = true; 
	    if (currentMethodType != Tab.noType) {
	    	report_error("Greska na liniji " + ers.getLine() + ": Povratna vrednost nije void a return je prazan", null);
	    }
	}
	
	public void visit(ArrayOrClassName daoc) {
		Obj alreadyExists = Tab.find(daoc.getArrayClassName());
		daoc.obj = alreadyExists;
		if (alreadyExists == Tab.noObj) {
			report_error("Greska na liniji " + daoc.getLine() + ": Identifikator " + daoc.getArrayClassName() + " ne postoji u tabeli simbola",null);
		} else {
			currentArrayOrClassName = daoc.getArrayClassName();
		}
	}
	
	public void visit(DesignatorElementExpr dee) {
		Obj arr = Tab.find(currentArrayOrClassName);
		if (arr.getType().getKind() != Struct.Array) {
			report_error("Greska na liniji " + dee.getLine() + ": " + currentArrayOrClassName + " nije niz.", null);
		} else {
			if (dee.getExpression().struct != Tab.intType) {
				report_error("Greska na liniji " + dee.getLine() +": Expression u izrazu [ expression ] nije tipa int.", null);
			}
			if (isReadStatement) {
				readDesignatorArrayElement = true; 
			}
		}
	}
	
	public void visit(NonEmptyReturnStatement ners) {
		returnFound = true; 
		returnIsEmpty = false; 
		if (currentMethodType == Tab.noType) {
			report_error("Greska na liniji " + ners.getLine() + ": Povratna vrednost je void a return nije prazan", null);
	    } else {
	    	if (currentMethodType != ners.getExpression().struct) {
	    		report_error("Greska na liniji " + ners.getLine() + ": Povratna vrednost i vrednost return iskaza nisu istog tipa",null);
	    	}
	    }
	}
	
	public void visit(ExistingSquareBrackets esb) {
		variableIsArray = true;
	}
	
	public void visit(NonExistingSquareBrackets nesb) {
		variableIsArray = false;
	}
	
	public void visit(VarDeclarationElem varDeclElem) {
		if (Tab.find(varDeclElem.getVariableName()) != Tab.noObj && (Tab.find(varDeclElem.getVariableName()).getKind() == Obj.Type || Tab.find(varDeclElem.getVariableName()).getKind() == Obj.Prog)) {
			report_error("Greska na liniji " + varDeclElem.getLine() + ": ne smete koristiti ime tipa ili programa za ime promenljive",null);
		} else {
			if (Tab.currentScope.findSymbol(varDeclElem.getVariableName()) != null){
				report_error("Greska na liniji " + varDeclElem.getLine() + ": Identifikator varijable vec postoji u tabeli simbola",null);
			} else {
				if (variableIsArray == true) {
					varDeclElem.obj = Tab.insert(Obj.Var, varDeclElem.getVariableName(), new Struct(Struct.Array, currentConstVarType));
				} else {
					varDeclElem.obj = Tab.insert(Obj.Var, varDeclElem.getVariableName(), currentConstVarType);	
				}
			}	
		}
		variableIsArray = false;
	}
	
	private void proveriUpotrebu(DesignatorAllList designator) {
		Obj objekat = null;
		String name = null;
		
		if (designator instanceof DesignatorIdent) {
			 objekat = Tab.find(((DesignatorIdent) designator).getI1());
			 name = ((DesignatorIdent) designator).getI1();
		} else {
			 objekat = Tab.find(((DesignatorArrayOrClass) designator).getArrayOrClassName().getArrayClassName());
			 name = ((DesignatorArrayOrClass)designator).getArrayOrClassName().getArrayClassName();
		}
			
		if (objekat.getKind() == Obj.Con) {
			report_info("Detektovana upotreba konstante " + name + " na liniji " + designator.getLine(), null);
		}
			
		if (objekat != Tab.noObj && objekat.getKind() == Obj.Var && objekat.getLevel() == 0 && objekat.getType().getKind() != Struct.Array) {
			report_info("Detektovana upotreba globalne promenljive " + name + " na liniji " + designator.getLine(), null);
		}
			
		if (objekat != Tab.noObj && objekat.getKind() == Obj.Var && objekat.getLevel() != 0 && objekat.getType().getKind() != Struct.Array) {
			report_info("Detektovana upotreba lokalne promenljive " + name + " na liniji " + designator.getLine(), null);
		}
			
		if (objekat.getKind() == Obj.Meth) {
			report_info("Detektovana upotreba globalne metode " + name + " na liniji " + designator.getLine(), null);
		}
	}
	
	
	
	public void visit(DesignatorArrayOrClass designatorIdent) {
		proveriUpotrebu(designatorIdent);
		
		designatorIdent.obj = Tab.find(designatorIdent.getArrayOrClassName().getArrayClassName());
		
		// ovde pazi ako je element niza
		
		if (designatorIdent.obj == Tab.noObj) {
			report_error("Greska na liniji " + designatorIdent.getLine() + ": Koristi se nedeklarisan simbol",null);
		}
		
		if (designatorIdent.obj.getType().getKind() == Struct.Array) {
		//ako je assign expression a koristi se konstanta 
			if (designatorIdent.getParent().getParent() instanceof DesignatorAssignExpress) {	
				if (designatorIdent.obj.getKind() == Obj.Con) {
					report_error("Greska na liniji " + designatorIdent.getLine() + ": Dodela vrednosti konstanti je zabranjena", null);
				} else {
					DesignatorElement designatorElement = null;
					if (designatorIdent.getDesignatorList() instanceof ExistingDesignatorListSingle) {
						designatorElement = ((ExistingDesignatorListSingle) designatorIdent.getDesignatorList()).getDesignatorElement();
					} else {
						designatorElement = ((ExistingDesignatorListMulti) designatorIdent.getDesignatorList()).getDesignatorElement();
					}
					
					if (designatorElement instanceof DesignatorElementIdent){
						report_error("Greska na liniji " + designatorIdent.getLine() + " : Polja klase nisu obradjivana u a fazi",null);
					} else {
						designatorIdent.obj = new Obj(Obj.Elem,"",designatorIdent.obj.getType().getElemType());
						report_info("Detektovano koriscenje elementa niza na liniji " + designatorIdent.getLine(),null);
					}
				}
			} else {
				DesignatorElement designatorElement = null;
				if (designatorIdent.getDesignatorList() instanceof ExistingDesignatorListSingle) {
					designatorElement = ((ExistingDesignatorListSingle) designatorIdent.getDesignatorList()).getDesignatorElement();
				} else {
					designatorElement = ((ExistingDesignatorListMulti) designatorIdent.getDesignatorList()).getDesignatorElement();
				}
				
				if (designatorElement instanceof DesignatorElementIdent){
					report_error("Greska na liniji " + designatorIdent.getLine() + " : Polja klase nisu obradjivana u a fazi",null);
				} else {
					designatorIdent.obj = new Obj(Obj.Elem,"",designatorIdent.obj.getType().getElemType());
					report_info("Detektovano koriscenje elementa niza na liniji " + designatorIdent.getLine(),null);
				}
			}
		} else {
			report_error("Greska na liniji " + designatorIdent.getLine() + " : Pristup strukturi koja nije niz kao elementu niza ili polju klase(klase nisu obradjivane za fazu a)",null);
		}
	}
	
	public void visit(DesignatorIdent designatorIdent) {
		proveriUpotrebu(designatorIdent);
		
		designatorIdent.obj = Tab.find(designatorIdent.getI1());
		
		if (designatorIdent.obj == Tab.noObj) {
			report_error("Greska na liniji " + designatorIdent.getLine() + ": Koristi se nedeklarisan simbol",null);
		}
		
		//ako je assign expression a koristi se konstanta 
		if (designatorIdent.getParent().getParent() instanceof DesignatorAssignExpress) {	
			if (designatorIdent.obj.getKind() == Obj.Con) {
				report_error("Greska na liniji " + designatorIdent.getLine() + ": Dodela vrednosti konstanti je zabranjena", null);
			} 
		}
	}
	
	public void visit(DesignatorAssignExpress designatorAssignExpression) {
		if (designatorAssignExpression.getDesignator().getDesignatorAllList() instanceof DesignatorIdent) {
			DesignatorIdent designatorIdent = (DesignatorIdent) designatorAssignExpression.getDesignator().getDesignatorAllList();
			
			Obj tabSym = Tab.find(designatorIdent.getI1());
			if (tabSym.getType().getKind() == Struct.Array)
			{
				Struct expressionStruct = designatorAssignExpression.getExpression().struct;
				if (expressionStruct == null)
					expressionStruct = Tab.noType;
				Struct designatorStruct = tabSym.getType();
				if (designatorStruct.getKind() == Struct.Array && expressionStruct == Tab.nullType) {
					
				} else {
				if (((designatorStruct.getKind() != expressionStruct.getKind())) || (designatorStruct.getElemType() != expressionStruct.getElemType()))
					report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Dodela vrednosti nizu osim naredbom new sa kompatibilnim tipom elemenata nije dozvoljena ili null referencom", null);
				}
			}
			else
			{
				if (tabSym.getKind() != Obj.Var)
				{
					report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Dodela vrednosti identifikatoru koji nije element niza ni ime promenljive", null);
				} 
				else
				{
					if (tabSym.getType() != designatorAssignExpression.getExpression().struct) {
						report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Nekompatibilne vrednosti pri iskazu dodele ",null);
					}
				}
			}
		} 
		else
		{
			DesignatorArrayOrClass dac = (DesignatorArrayOrClass) designatorAssignExpression.getDesignator().getDesignatorAllList();
			String name = dac.getArrayOrClassName().getArrayClassName();
			if (Tab.find(name).getType().getKind() == Struct.Array)
			{
				if (dac.getDesignatorList() instanceof ExistingDesignatorListSingle) 
				{
					ExistingDesignatorListSingle single = (ExistingDesignatorListSingle) dac.getDesignatorList();
					if (single.getDesignatorElement() instanceof DesignatorElementExpr)
					{
						if (Tab.find(name).getType().getElemType() != designatorAssignExpression.getExpression().struct)
						{
							report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Nekompatibilne vrednosti pri dodeli", null);
						}
					}
					else 
					{
						report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Koristi se ime niza pri dodeli vrednosti ali ne i pristup elementu niza ",null);
					}
				}
				else
				{
					report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Dodela vrednosti elementu visedimenzionalnog niza",null);
				}
			}
			else
			{
				report_error("Greska na liniji " + designatorAssignExpression.getLine() + ": Dodela vrednosti identifikatoru koji nije promenljiva ili element niza",null);
			}
		}
	}
	
	public void visit(ActParsDesignatorStatement statement)
	{
		if (statement.getDesignator().getDesignatorAllList() instanceof DesignatorIdent)
		{
			String methodName = ((DesignatorIdent) statement.getDesignator().getDesignatorAllList()).getI1();
			
			if (Tab.find(methodName).getKind() == Obj.Meth && (methodName.equals("ord") || methodName.equals("chr") || methodName.equals("len"))) {
				if (methodName.equals("ord")) {
					if (statement.getOptionalActPars() instanceof NonExistingActPars) {
						report_error("Greska na liniji " + statement.getLine() + ": Poziv ord metode bez argumenata",null);
					} else {
						if (((ExistingActPars)statement.getOptionalActPars()).getActPars() instanceof MultiActPars) {
							report_error("Greska na liniji " + statement.getLine() + ": Poziv ord metode sa vise argumenata",null);
						} else {
							SingleActPars singleActPars = (SingleActPars)((ExistingActPars)statement.getOptionalActPars()).getActPars();
							if (singleActPars.getExpression().struct != Tab.charType) {
								report_error("Greska na liniji " + statement.getLine() + ": Poziv ord metode sa argumentom koji nije tipa char",null);
							}
						}
					}
				}
				
				if (methodName.equals("chr")) {
					if (statement.getOptionalActPars() instanceof NonExistingActPars) {
						report_error("Greska na liniji " + statement.getLine() + ": Poziv chr metode bez argumenata",null);
					} else {
						if (((ExistingActPars)statement.getOptionalActPars()).getActPars() instanceof MultiActPars) {
							report_error("Greska na liniji " + statement.getLine() + ": Poziv chr metode sa vise argumenata",null);
						} else {
							SingleActPars singleActPars = (SingleActPars)((ExistingActPars)statement.getOptionalActPars()).getActPars();
							if (singleActPars.getExpression().struct != Tab.intType) {
								report_error("Greska na liniji " + statement.getLine() + ": Poziv chr metode sa argumentom koji nije tipa int",null);
							}
						}
					}
				}
				
				if (methodName.equals("len")) {
					if (statement.getOptionalActPars() instanceof NonExistingActPars) {
						report_error("Greska na liniji " + statement.getLine() + ": Poziv chr metode bez argumenata",null);
					} else {
						if (((ExistingActPars)statement.getOptionalActPars()).getActPars() instanceof MultiActPars) {
							report_error("Greska na liniji " + statement.getLine() + ": Poziv chr metode sa vise argumenata",null);
						} else {
							SingleActPars singleActPars = (SingleActPars)((ExistingActPars)statement.getOptionalActPars()).getActPars();
							if (singleActPars.getExpression().struct.getKind() != Struct.Array || (singleActPars.getExpression().struct.getElemType() != Tab.intType && singleActPars.getExpression().struct != Tab.charType)) {
								report_error("Greska na liniji " + statement.getLine() + ": Poziv len metode sa argumentom koji nije tipa char ili int niz",null);
							}
						}
					}
				}
			} else {
				if (Tab.find(methodName) == Tab.noObj)
				{
					report_error("Greska na liniji " + statement.getLine() + ": Identifikator pri pozivu funkcije ne postoji u tabeli simbola",null);
				}
				else
				{
					if (Tab.find(methodName).getKind() != Obj.Meth)
					{
						report_error("Greska na liniji " + statement.getLine() + ": Identifikator pri pozivu funkcije nije ime metode",null);
					}
				}
			}
		}
		else
		{
			report_error("Greska na liniji " + statement.getLine() + ": Identifikator pri pozivu funkcije nije ime globalne funkcije ili funkcije unutrasnje klase",null);
		}
	}
	
	public void visit(OptionalOptionalActParsNotExist arg) {
		isIdent = true; 
	}
	
	public void visit(OptionalOptionalActParsExist arg) {
		isIdent = false;
	}
	
	public void visit(FactorDesignator factorDesignator) {
		if (isIdent == true) {
			if (factorDesignator.getDesignator().getDesignatorAllList() instanceof DesignatorIdent)
			{		
				Obj factorObj = factorDesignator.getDesignator().getDesignatorAllList().obj;
				
				if (factorObj.getKind() != Obj.Meth && factorObj.getKind() != Obj.Prog && factorObj.getKind() != Obj.Type)
					factorDesignator.struct = factorDesignator.getDesignator().getDesignatorAllList().obj.getType();
				else 
					report_error("Greska na liniji " + factorDesignator.getLine() + ": Identifikator u Factor Designatoru nije odgovarajuce vrste", null);
			
			}
			else
			{
				String name = ((DesignatorArrayOrClass) factorDesignator.getDesignator().getDesignatorAllList()).getArrayOrClassName().getArrayClassName();
				DesignatorList element = ((DesignatorArrayOrClass) factorDesignator.getDesignator().getDesignatorAllList()).getDesignatorList();
				
				if (element instanceof ExistingDesignatorListSingle)
				{
					DesignatorElement singleElement = ((ExistingDesignatorListSingle) element).getDesignatorElement();
					if (singleElement instanceof DesignatorElementExpr)
					{
						if (Tab.find(name).getType().getKind() == Struct.Array)
						{
							factorDesignator.struct = Tab.find(name).getType().getElemType();
						}
						else
						{
							report_error("Greska na liniji " + factorDesignator.getLine() + ": Koristi se pristup nizu a identifikator nije ime niza",null);
						}
					}
					else
					{
						//Polje objekta klase
					}
				}
				else
				{
					//visedimenzionalni niz ili polje klase
				}
			}
		} else {
			
			if (factorDesignator.getDesignator().getDesignatorAllList() instanceof DesignatorIdent) {
			   String methodName = ((DesignatorIdent) factorDesignator.getDesignator().getDesignatorAllList()).getI1();
			   if (factorDesignator.getDesignator().getDesignatorAllList().obj.getKind() == Obj.Meth && (methodName.equals("ord") || methodName.equals("chr") || methodName.equals("len")) && factorDesignator.getOptionalOptionalActPars() instanceof OptionalOptionalActParsExist) {
						if (methodName.equals("ord")) {
							if (((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars() instanceof NonExistingActPars) {
								report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv ord metode bez argumenata",null);
							} else {
								if (((ExistingActPars)((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars()).getActPars() instanceof MultiActPars) {
									report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv ord metode sa vise argumenata",null);
								} else {
									SingleActPars singleActPars = (SingleActPars)((ExistingActPars)((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars()).getActPars();
									if (singleActPars.getExpression().struct != Tab.charType) {
										report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv ord metode sa argumentom koji nije tipa char",null);
									} else { factorDesignator.struct = Tab.find(methodName).getType(); }
								}
							}
						}
						
						if (methodName.equals("chr")) {
							if (((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars() instanceof NonExistingActPars) {
								report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv chr metode bez argumenata",null);
							} else {
								if (((ExistingActPars)((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars()).getActPars() instanceof MultiActPars) {
									report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv chr metode sa vise argumenata",null);
								} else {
									SingleActPars singleActPars = (SingleActPars)((ExistingActPars)((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars()).getActPars();
									if (singleActPars.getExpression().struct != Tab.intType) {
										report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv chr metode sa argumentom koji nije tipa int",null);
									} else { factorDesignator.struct = Tab.find(methodName).getType(); }
								}
							}
						}
						
						if (methodName.equals("len")) {
							if (((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars() instanceof NonExistingActPars) {
								report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv len metode bez argumenata",null);
							} else {
								if (((ExistingActPars)((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars()).getActPars() instanceof MultiActPars) {
									report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv len metode sa vise argumenata",null);
								} else {
									SingleActPars singleActPars = (SingleActPars)((ExistingActPars)((OptionalOptionalActParsExist)factorDesignator.getOptionalOptionalActPars()).getOptionalActPars()).getActPars();
									if (singleActPars.getExpression().struct.getKind() != Struct.Array || (singleActPars.getExpression().struct.getElemType() != Tab.intType && singleActPars.getExpression().struct.getElemType()!= Tab.charType)) {
										report_error("Greska na liniji " + factorDesignator.getLine() + ": Poziv len metode sa argumentom koji nije tipa niz intova ili charova",null);
									} else { factorDesignator.struct = Tab.find(methodName).getType(); }
								}
							}
						}
			   } else {
			   //////////////////////////
			   //////////////////////////
			   //////////////////////////
			   //////////////////////////
			   Obj method = Tab.find(methodName);
			   if (method == Tab.noObj) {
				   report_error("Greska na liniji " + factorDesignator.getLine() + ": identifikator funkcije ne postoji u tabeli simbola.", null);
			   } else {
				   
				   if (method.getKind() != Obj.Meth) {
					   report_error("Greska na liniji " + factorDesignator.getLine() + ": identifikator funkcije nije tipa metoda.", null);
				   } else {
					   factorDesignator.struct = method.getType();
				   }
			   }
			}
			} else {
				//klasa ili niz metoda
				report_error("Greska na liniji " + factorDesignator.getLine() + ": identifikator funkcije je ime niza ili klase.", null);
			}
		}
	}
	
	public void visit(Designator designator) {
		designator.obj = designator.getDesignatorAllList().obj;
	}
	
	public void visit(TermSingleFactor arg) {
		arg.struct = arg.getFactor().struct;
	}
	
	public void visit(TermMultiFactor termMultiFactor){
		Struct first = termMultiFactor.getFactor().struct;
		Struct second = termMultiFactor.getTerm().struct;
		
		if (first.getKind() == Struct.Array && second.getKind() == Struct.Array && first.getElemType() == second.getElemType() && termMultiFactor.getMulOp() instanceof MulOpMultiply){
			termMultiFactor.struct = Tab.intType;
		} else {
			if ((termMultiFactor.getMulOp() instanceof MulOpMultiply) &&
				(( first == Tab.charType && second.getKind() == Struct.Array && second.getElemType() == Tab.charType)
				||(first.getKind() == Struct.Array && first.getElemType() == Tab.charType && second == Tab.charType)
				||(first == Tab.intType && second.getKind() == Struct.Array && second.getElemType() == Tab.intType)
				||(first.getKind() == Struct.Array && first.getElemType() == Tab.intType && second == Tab.intType)))
			{
				if (first.getKind() == Struct.Array) {
					termMultiFactor.struct = first;
				} else {
					termMultiFactor.struct = second;
				}
				
			} else {
				if (termMultiFactor.getFactor().struct != Tab.intType) {
					report_error("Greska na liniji " + termMultiFactor.getLine() + ": Faktor u izrazu nije tipa int ili su array ali ne ispunjavaju uslove da su oba istog tipa i da je operacija * ili da je jedan skalar a drugi niz i kompatibilnih su tipova", null);
				} else {
					if (termMultiFactor.getTerm().struct != Tab.intType) {
						report_error("Greska na liniji " + termMultiFactor.getLine() + ": Faktor u izrazu nije tipa int ili su array ali ne ispunajvaju uslove da su oba istog tipa i da je operacija * ili da je jedan skalar a drugi niz i kompatibilnih su tipova", null);
					} else {
						termMultiFactor.struct = Tab.intType;
					}
				}
			}
		}
	}
	
	public void visit(SingleExpressionList singleExpressionList){
		singleExpressionList.struct = singleExpressionList.getTerm().struct; 
	}
	
	public void visit(MultiExpressionlist multiExpressionlist) {
		Struct structFirst = multiExpressionlist.getExpressionList().struct;
		Struct structSecod = multiExpressionlist.getTerm().struct; 
		
		if (structFirst == null || structSecod == null) { 
			report_error("Greska na liniji " + multiExpressionlist.getLine() + ": Greska u izrazu sa vise operanada",null);
		} else {
		if (multiExpressionlist.getExpressionList().struct.getKind() == Struct.Array && multiExpressionlist.getTerm().struct.getKind() == Struct.Array) {
				if (multiExpressionlist.getExpressionList().struct.getElemType() != multiExpressionlist.getTerm().struct.getElemType())
				{
					report_error("Greska na liniji " + multiExpressionlist.getLine() + " : Operandi operacije + su nizovi ali elementi im nisu istog tipa ",null);
				} else {
					if (multiExpressionlist.getAddOp() instanceof MinusAddOp) {
						report_error("Greska na liniji " + multiExpressionlist.getLine() + " Oduzimanje nizova nije dozvoljeno",null);
					} else {
						multiExpressionlist.struct = multiExpressionlist.getExpressionList().struct;
					}
				}
			} else {
				if (multiExpressionlist.getTerm().struct != Tab.intType) {
					report_error("Greska na liniji " + multiExpressionlist.getLine() + ": Faktor u izrazu nije tipa int.", null);
				} else {
					if (multiExpressionlist.getExpressionList().struct != Tab.intType) {
						report_error("Greska na liniji " + multiExpressionlist.getLine() + ": Faktor u izrazu nije tipa int.", null);
					} else {
						multiExpressionlist.struct = Tab.intType;
					}
				}
			}
		}
	}
	
	public void visit(Expression expression) {
		expression.struct = expression.getExpressionList().struct;
		if (needsToBeIntBecauseOfMinus && expression.struct != Tab.intType) {
			report_error("Greska na liniji " + expression.getLine() + ": Izraz sa minusom ispred nije tipa int",null);
		}
	}
	
	public void visit(FactorNumConst factorNumConst) {
		factorNumConst.struct = Tab.intType;
	}
	
	public void visit(FactorCharConst factorCharConst) {
		factorCharConst.struct = Tab.charType;
	}
	
	public void visit(FactorBoolConst factorBoolConst) {
		factorBoolConst.struct = Tab.find("bool").getType();
	}
	
	public void visit(ExistingOptionalMinus arg) {
		needsToBeIntBecauseOfMinus = true;
	}
	
	public void visit(NonExistingOptionalMinus arg) {
		needsToBeIntBecauseOfMinus = false;
	}
	
	public void visit(FormParamNoErr formPar) {
		Obj formParType = Tab.find(formPar.getType().getTypeName());
		Obj alreadyExists = Tab.currentScope.findSymbol(formPar.getI2());
		if (formParType == null || formParType == Tab.noObj || formParType.getType() == Tab.noType) {
			report_error("Greska na liniji " + formPar.getLine() + " : Nedozvoljen tip za parametar metode", null);
		} else {
			if (alreadyExists != null) {
				report_error("Greska na liniji " + formPar.getLine() + ": parametar sa datim imenom vec postoji u scope-u.", null);
			} else {
				if (formPar.getOptionalSquareBrackets() instanceof ExistingSquareBrackets)
					formPar.obj = Tab.insert(Obj.Var, formPar.getI2(), new Struct(Struct.Array,formParType.getType()));
				else
					formPar.obj = Tab.insert(Obj.Var, formPar.getI2(), formParType.getType());
				SyntaxNode parent = formPar.getParent();
				while (parent != null && ((parent instanceof MethodDeclaration) == false))
					parent = parent.getParent();
				if (parent != null) {
					String methodName = ((MethodDeclaration)parent).getMethodName().getMethodName();
					Obj methodObject = Tab.find(methodName);
					methodObject.setLevel(methodObject.getLevel() + 1);
					formPar.obj.setFpPos(methodObject.getLevel());
					listOfFormalParameters.add(formPar.obj);
				}
			}
		}
	}
	
	public void visit(NonExistingActPars arguments) {
		SyntaxNode parent = arguments.getParent();
		while(parent != null && ((parent instanceof FactorDesignator) == false) && ((parent instanceof ActParsDesignatorStatement) == false)) {
			parent = parent.getParent();
		}
		
		if (parent != null) {
			Obj objekat = null;
			if (parent instanceof FactorDesignator)
				objekat = ((FactorDesignator) parent).getDesignator().obj;
			else 
				objekat = ((ActParsDesignatorStatement) parent).getDesignator().obj;
			
			if (objekat.getKind() != Obj.Meth) {
				report_error("Greska na liniji " + arguments.getLine() + ": Koristi se identifikator koji nije ime metode kao poziv metode ",null);
			} else {
				if (objekat.getLevel() != 0) {
					report_error("Greska na liniji " + arguments.getLine() + ": Pri pozivu nisu prosledjeni argumenti metode a ona ima parametre",null);
				}
			}
		}
	}
	
	public void visit(ExistingActPars arguments) {
		SyntaxNode parent = arguments.getParent();
		while(parent != null && ((parent instanceof FactorDesignator) == false) && ((parent instanceof ActParsDesignatorStatement) == false)) {
			parent = parent.getParent();
		}
		
		if (parent != null) {
			Obj objekat = null;
			String methodName = null;
			if (parent instanceof FactorDesignator) {
				objekat = ((FactorDesignator) parent).getDesignator().obj;
				methodName = ((DesignatorIdent)((FactorDesignator)parent).getDesignator().getDesignatorAllList()).getI1();
			}
			else 
			{
				objekat = ((ActParsDesignatorStatement) parent).getDesignator().obj;
				methodName = ((DesignatorIdent)((ActParsDesignatorStatement)parent).getDesignator().getDesignatorAllList()).getI1();
			}
			
			
			if (objekat.getKind() != Obj.Meth) {
				report_error("Greska na liniji " + arguments.getLine() + ": Koristi se identifikator koji nije ime metode kao poziv metode ",null);
			} else {
				if (methodName.equals("ord") == false && methodName.equals("chr") == false && methodName.equals("len") == false) {
					SyntaxNode parentNode = arguments.getParent();
					while(parentNode != null)
					{
						if (parentNode instanceof MethodDeclaration) {
							String name = ((MethodDeclaration) parentNode).getMethodName().getMethodName();
							if (name.equals(methodName))
								break;
						}
						parentNode = parentNode.getParent();
					}
					
					
					if (parentNode == null && (Tab.find(methodName).getKind() != Obj.Meth || Tab.find(methodName) == Tab.noObj)) {
						report_error("Greska na liniji " + arguments.getLine() + ": metoda nije deklarisana",null);
					} else {
						
						List<Obj> listaParametara = null;
						if (parentNode != null) {
							MethodDeclaration declaration = (MethodDeclaration) parentNode;
							OptionalFormPars formPars = declaration.getOptionalFormPars();
							if (formPars instanceof NonExistingFormPars) {
								listaParametara = new ArrayList<Obj>();
							} else {
								ExistingFormPars ePars = (ExistingFormPars) formPars;
								listaParametara = new ArrayList<Obj>();
								if (ePars.getFormPars() instanceof SingleFormPars) {
									listaParametara.add(((SingleFormPars) ePars.getFormPars()).getFormPar().obj);
								} else {
									FormPars frmPars = ePars.getFormPars();
									while(frmPars instanceof MultiFormPars) {
										listaParametara.add(0,((MultiFormPars) frmPars).getFormPar().obj);
										frmPars = ((MultiFormPars) frmPars).getFormPars();
									}
									listaParametara.add(0,((SingleFormPars)frmPars).getFormPar().obj);
								}
							}
						} else {
							List<Obj> listaParametaraTemp = new ArrayList(Tab.find(methodName).getLocalSymbols());
							
							listaParametara = new ArrayList();
							
							int brojArg = 0;
							
							for (Obj elem : listaParametaraTemp)
								if (elem.getFpPos() > 0)
									brojArg ++; 
							
							for (int i = 0; i < listaParametaraTemp.size(); i++) {
								for (int j = 0; j < listaParametaraTemp.size(); j++) {
									if (listaParametaraTemp.get(j).getFpPos() == i+1) {
										listaParametara.add(listaParametaraTemp.get(j));
										break;
									}
								}
							}
						}
						
						List<Expression> listaArgumenata = new ArrayList<Expression>();
						listaArgumenata = findArgs(arguments.getActPars());
						
						if (listaArgumenata.size() != listaParametara.size()) {
							report_error("Greska na liniji " + arguments.getLine() + ": poziv metode sa pogresnim brojem argumenata",null);
						} else {
							for (int i = 0; i < listaArgumenata.size(); i++) {
								Struct argType = listaArgumenata.get(i).struct;
								Struct paramType = findParameterByIndex(i+1, listaParametara).getType();
						
								if (paramType.getKind() == Struct.Array && argType != Tab.nullType) {
								if (argType.getKind() == Struct.Array && paramType.getKind() == Struct.Array) {
									if (argType.getElemType() != paramType.getElemType())
										report_error("Greska na liniji " + arguments.getLine() + ": argument i parametar su nizovi ali nisu kompatibilni",null);
									} else {
										if (argType != paramType)
											report_error("Greska na liniji " + arguments.getLine() + ": Tipovi argumenata pri pozivu funkcije i njenom deklarisanju se razlikuju", null);
									}
								}
							}
					  }
				
				   }
			     }
				}
			}
		}
	
	private Obj findParameterByIndex(int index, List<Obj> list) {
		for (Obj elem : list) {
			if (elem.getFpPos() == index)
				return elem;
		}
		return null;
	}
	
	private List<Expression> findArgs(ActPars arguments){
		List<Expression> result = new ArrayList();
		
		if (arguments instanceof MultiActPars) {
			while(arguments  instanceof MultiActPars) {
				result.add(0,((MultiActPars) arguments).getExpression());
				arguments = ((MultiActPars) arguments).getActPars();
			}
			
			result.add(0,((SingleActPars)arguments).getExpression());
		} else {
			result.add(0,((SingleActPars)arguments).getExpression());
		}
		return result;
	}
	
	public void visit(FactorNewTypeWithExpr factor) {
		String factorType = factor.getType().getTypeName();
		if (Tab.find(factorType) == Tab.noObj) {
			report_error("Greska na liniji " + factor.getLine() + ": Tip " + factorType + " nije definisan u tabeli simbola", null);
		} else {
			if (Tab.find(factorType).getKind() != Obj.Type) {
				report_error("Greska na liniji " + factor.getLine() + ": " + factorType + " nije tip podataka", null);
			} else {
				if (factor.getExpression().struct != Tab.intType) {
					report_error("Greska na liniji " + factor.getLine() + ": Expression u izrazu new Type[Expression] nije tipa int", null);
				} else {
					factor.struct = new Struct(Struct.Array, Tab.find(factorType).getType());
				}
			}
		}
	}
	
	public void visit(PrintStatementWithoutNumConst arg) {
		Struct argumentStruct = arg.getExpression().struct;
		if (argumentStruct != Tab.intType && argumentStruct != Tab.charType && argumentStruct != Tab.find("bool").getType()) {
			report_error("Greska na liniji " + arg.getLine() + ": Iskaz u print naredbi nije ni int, ni char, ni bool", null);
		}
	}
	
	public void visit(PrintStatementWithNumConst arg) {
		Struct argumentStruct = arg.getExpression().struct;
		if (argumentStruct != Tab.intType && argumentStruct != Tab.charType && argumentStruct != Tab.find("bool").getType()) {
			report_error("Greska na liniji " + arg.getLine() + ": Iskaz u print naredbi nije ni int, ni char, ni bool", null);
		}
	}
	
	public void visit(ReadStatement readStm) {
		Designator designator  = readStm.getDesignator();
		if (designator.getDesignatorAllList() instanceof DesignatorIdent)
		{
			String name = ((DesignatorIdent) designator.getDesignatorAllList()).getI1();
			if (Tab.find(name).getKind() != Obj.Var)
			{
				report_error("Greska na liniji " + readStm.getLine() + ": Designator u read naredbi nije promenljiva,element niza ili objekat klase",null);
			}
			else
			{
				if (Tab.find(name).getType() != Tab.intType && Tab.find(name).getType() != Tab.charType && Tab.find(name).getType() != Tab.find("bool").getType())
				{
					report_error("Greska na liniji " + readStm.getLine() + ": Designator u read naredbi nije tipa int,bool ili char",null);
				}
			}
		}
		else
		{
			String name = ((DesignatorArrayOrClass) designator.getDesignatorAllList()).getArrayOrClassName().getArrayClassName();
			DesignatorArrayOrClass arrayOrClass = (DesignatorArrayOrClass) designator.getDesignatorAllList();
			
			if (arrayOrClass.getDesignatorList() instanceof ExistingDesignatorListSingle)
			{
				DesignatorElement element = ((ExistingDesignatorListSingle) arrayOrClass.getDesignatorList()).getDesignatorElement();
				
				if (element instanceof DesignatorElementExpr)
				{
					if (Tab.find(name).getType().getKind() != Struct.Array)
					{
						report_error("Greska na liniji " + readStm.getLine() + ": Designator u read naredbi se koristi kao niz iako identifikator nije identifikator niza",null);
					}
					else
					{
						if (Tab.find(name).getType().getElemType() != Tab.intType && Tab.find(name).getType().getElemType() != Tab.charType && Tab.find(name).getType().getElemType() != Tab.find("bool").getType())
						{
							report_error("Greska na liniji " + readStm.getLine() + ": Designator u read naredbi kao element niza nije tipa int,bool ili char",null);
						}
					}
				}
				else
				{
					report_error("Greska na liniji " + readStm.getLine() + ": Designator u read naredbi je objekat klase ", null);
				}
			}
			else
			{
				report_error("Greska na liniji " + readStm.getLine() + ": Designator u read naredbi je objekat klase ili visedimenzionalni niz",null);
			}
			
		}

		readDesignatorArrayElement = false;
		isReadStatement = false; 
	}
	
	public void visit(IncDesignatorStatement incStatement) {
		DesignatorAllList designator = incStatement.getDesignator().getDesignatorAllList();
		
		if (designator instanceof DesignatorIdent) {
			String designatorName = ((DesignatorIdent) designator).getI1();
			Obj tabSym = Tab.find(designatorName);
			if (tabSym.getKind() == Obj.Var) {
				if (tabSym == Tab.noObj) {
					report_error("Greska na liniji " + incStatement.getLine() + ": Designator uz increment statement ne postoji u tabeli simbola", null);
				} else {
					if (tabSym.getType() != Tab.intType) {
						report_error("Greska na liniji " + incStatement.getLine() + ": Designator uz increment statement nije tipa int", null);
					}
				}
			} else {
				report_error("Greska na liniji " + incStatement.getLine() + ": Designator u increment naredbi nije promenljiva,element niza ili polje objekta unutrsanje klase",null);
			}
		} else {
			//niz ili klasa
			DesignatorList designatorList = ((DesignatorArrayOrClass) designator).getDesignatorList();
			String designatorName = ((DesignatorArrayOrClass) designator).getArrayOrClassName().getArrayClassName();
			DesignatorElement designatorElement = null; 
			
			Obj tabSym = Tab.find(designatorName);
			if (tabSym == Tab.noObj) {
				report_error("Greska na liniji " + incStatement.getLine() + ": Designator uz increment statement ne postoji u tabeli simbola", null);
			} else {
				if (designatorList instanceof ExistingDesignatorListMulti) {
					designatorElement = ((ExistingDesignatorListMulti) designatorList).getDesignatorElement();
				} else {
					designatorElement = ((ExistingDesignatorListSingle) designatorList).getDesignatorElement();
				}
				
				if (!(designatorElement instanceof DesignatorElementExpr)) {
					//objekat klase,ne treba za 20 poena
					report_error("Greska na liniji " + incStatement.getLine() + ": Designator uz increment statement nije element niza vec polje klase", null);
				} else {
					if (tabSym.getType().getKind() != Struct.Array) {
						report_error("Greska na liniji " + incStatement.getLine() + ": Identifikator u designatoru increment naredbe nije ime niza.", null);
					} else {
						if (tabSym.getType().getElemType() != Tab.intType) {
							report_error("Greska na liniji " + incStatement.getLine() + ": Designator u increment narebi kao element niza nije tipa int.", null);
						}
				    }
				}
			}
			
			
		}
	}
	
	public void visit(DecDesignatorStatement decStatement) {
		DesignatorAllList designator = decStatement.getDesignator().getDesignatorAllList();
		
		if (designator instanceof DesignatorIdent) {
			String designatorName = ((DesignatorIdent) designator).getI1();
			Obj tabSym = Tab.find(designatorName);
			if (tabSym.getKind() == Obj.Var) {
				if (tabSym == Tab.noObj) {
					report_error("Greska na liniji " + decStatement.getLine() + ": Designator uz increment statement ne postoji u tabeli simbola", null);
				} else {
					if (tabSym.getType() != Tab.intType) {
						report_error("Greska na liniji " + decStatement.getLine() + ": Designator uz increment statement nije tipa int", null);
					}
				}
			} else {
				report_error("Greska na liniji " + decStatement.getLine() + ": Designator uz decrement naredbu nije promenljiva, element niza ili polje objekta unutrasnje klase",null);
			}
		} else {
			//niz ili klasa
			DesignatorList designatorList = ((DesignatorArrayOrClass) designator).getDesignatorList();
			String designatorName = ((DesignatorArrayOrClass) designator).getArrayOrClassName().getArrayClassName();
			DesignatorElement designatorElement = null; 
			
			Obj tabSym = Tab.find(designatorName);
			if (tabSym == Tab.noObj) {
				report_error("Greska na liniji " + decStatement.getLine() + ": Designator uz increment statement ne postoji u tabeli simbola", null);
			} else {
				if (designatorList instanceof ExistingDesignatorListMulti) {
					designatorElement = ((ExistingDesignatorListMulti) designatorList).getDesignatorElement();
				} else {
					designatorElement = ((ExistingDesignatorListSingle) designatorList).getDesignatorElement();
				}
				
				if (!(designatorElement instanceof DesignatorElementExpr)) {
					//objekat klase,ne treba za 20 poena
					report_error("Greska na liniji " + decStatement.getLine() + ": Designator uz increment statement nije element niza vec polje klase", null);
				} else {
					if (tabSym.getType().getKind() != Struct.Array) {
						report_error("Greska na liniji " + decStatement.getLine() + ": Identifikator u designatoru increment naredbe nije ime niza.", null);
					} else {
						if (tabSym.getType().getElemType() != Tab.intType) {
							report_error("Greska na liniji " + decStatement.getLine() + ": Designator u increment narebi kao element niza nije tipa int.", null);
						}
				    }
				}
			}
			
			
		}
	}
	
	
	public void visit(FactorBracketExpression bracketExpression) {
		bracketExpression.struct = bracketExpression.getExpression().struct;
	}
	
	public void visit(ReadSt readStm) {
		isReadStatement = true; 
	}
	
	public void visit(SingleCondFact condFact) {
		condFact.struct = condFact.getExpression().struct;
	}
	
	public void visit(MultiCondFact condFact) {
		Struct first = condFact.getExpression().struct;
		Struct second = condFact.getExpression1().struct;
		
		if ((condFact.getExpression().struct != condFact.getExpression1().struct) && condFact.getExpression().struct != Tab.nullType && condFact.getExpression1().struct != Tab.nullType) {
			report_error("Greska na liniji " + condFact.getLine() + ": Condition fact ima operande uz relop koji nisu kompatibilni",null);
		} else {
			if ((first.getKind() == Struct.Array && second.getKind() == Struct.Array) || (first == Tab.nullType && second.getKind() == Struct.Array) || (first.getKind() == Struct.Array && second == Tab.nullType) ) {
				if (!((condFact.getRelop() instanceof EqRelop) || (condFact.getRelop() instanceof NeqRelop))) {
					report_error("Greska na liniji " + condFact.getLine() + ": uz promenljive tipa niza mogu se koristi samo operatori == i != ",null);
				} else {
					condFact.struct = Tab.find("bool").getType();
				}
			} else {
				if (first == Tab.nullType && second == Tab.nullType) {
					report_error("Greska na liniji " + condFact.getLine() + ": Oba expressiona u conditionu su null",null);
				} else {
					condFact.struct = Tab.find("bool").getType();
				}
			}
		}
	}
	
	public void visit(SingleCondTermList condTermList) {
		condTermList.struct = condTermList.getCondTerm().struct;
	}
	
	public void visit(MultiCondTermList condTermList) {
		Struct structPrvi = condTermList.getCondTerm().struct;
		Struct structDrugi = condTermList.getCondTermOrList().struct;
		
		if (structPrvi != Tab.find("bool").getType() || structDrugi != Tab.find("bool").getType()) {
			report_error("Greska na liniji " + condTermList.getLine() + ": Operatori u cond fact listi koji sacinjavaju condition nisu boolean ",null);
		} else {
			condTermList.struct = Tab.find("bool").getType();
		}
	}
	
	public void visit(CondTerm condTerm) {
		condTerm.struct = condTerm.getCondFactList().struct;
	}
	
	public void visit(Condition condition) {
		condition.struct = condition.getCondTermOrList().struct;
	}
	
	public void visit(MultiCondFactList condFactList) {
		Struct structPrvi = condFactList.getCondFact().struct;
		Struct structDrugi = condFactList.getCondFactList().struct;
		
		if (structPrvi != Tab.find("bool").getType() || structDrugi != Tab.find("bool").getType()) {
			report_error("Greska na liniji " + condFactList.getLine() + ": Operatori u cond fact listi koji sacinjavaju condition nisu boolean ",null);
		} else {
			condFactList.struct = Tab.find("bool").getType();
		}
	}
	
	public void visit(SingleCondFactList condFactList) {
		condFactList.struct = condFactList.getCondFact().struct;
	}
	
	public void visit(IfCond ifCondition) {
		if (ifCondition.getCondition().struct != Tab.find("bool").getType()) {
			report_error("Greska na liniji " + ifCondition.getLine() + " : Condition u if naredbi nije tipa bool",null);
		}
	}
	
	public void visit(BreakStm breakStm) {
		SyntaxNode parent = breakStm.getParent();
		while (parent != null && ((parent instanceof DoStatement) == false))
			parent = parent.getParent();
		
		if (parent == null)
			report_error("Greska na liniji " + breakStm.getLine() + ": break naredba se moze naci samo unutar do while petlje",null);
	}
	
	public void visit(DoStatement doStatement) {
		if (doStatement.getWhileCond().getCondition().struct != Tab.find("bool").getType()) {
			report_error("Greska na liniji " + doStatement.getLine() + " : Condition u do naredbi nije tipa bool ", null);
		}
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
}

