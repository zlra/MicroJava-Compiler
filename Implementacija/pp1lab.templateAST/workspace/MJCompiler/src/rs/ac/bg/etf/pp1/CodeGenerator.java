package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.transaction.TransactionRequiredException;

import com.sun.image.codec.jpeg.TruncatedFileException;
import com.sun.xml.internal.bind.marshaller.MinimumEscapeHandler;

import rs.ac.bg.etf.pp1.ast.ActParsDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.AddOp;
import rs.ac.bg.etf.pp1.ast.ArrayOrClassName;
import rs.ac.bg.etf.pp1.ast.BreakStm;
import rs.ac.bg.etf.pp1.ast.ContinueStm;
import rs.ac.bg.etf.pp1.ast.DecDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayOrClass;
import rs.ac.bg.etf.pp1.ast.DesignatorAssignExpress;
import rs.ac.bg.etf.pp1.ast.DesignatorIdent;
import rs.ac.bg.etf.pp1.ast.Do;
import rs.ac.bg.etf.pp1.ast.DoStatement;
import rs.ac.bg.etf.pp1.ast.Else;
import rs.ac.bg.etf.pp1.ast.EmptyReturnStatement;
import rs.ac.bg.etf.pp1.ast.EqRelop;
import rs.ac.bg.etf.pp1.ast.ExistingOptionalElse;
import rs.ac.bg.etf.pp1.ast.ExistingOptionalMinus;
import rs.ac.bg.etf.pp1.ast.ExistingOptionalVarDeclList;
import rs.ac.bg.etf.pp1.ast.Expression;
import rs.ac.bg.etf.pp1.ast.FactorBoolConst;
import rs.ac.bg.etf.pp1.ast.FactorCharConst;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorNewTypeWithExpr;
import rs.ac.bg.etf.pp1.ast.FactorNumConst;
import rs.ac.bg.etf.pp1.ast.GtRelop;
import rs.ac.bg.etf.pp1.ast.GteRelop;
import rs.ac.bg.etf.pp1.ast.IfStart;
import rs.ac.bg.etf.pp1.ast.IfStatement;
import rs.ac.bg.etf.pp1.ast.IfThenPart;
import rs.ac.bg.etf.pp1.ast.IncDesignatorStatement;
import rs.ac.bg.etf.pp1.ast.LtRelop;
import rs.ac.bg.etf.pp1.ast.LteRelop;
import rs.ac.bg.etf.pp1.ast.MethodDeclaration;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.MinusAddOp;
import rs.ac.bg.etf.pp1.ast.MulOpDivide;
import rs.ac.bg.etf.pp1.ast.MulOpMod;
import rs.ac.bg.etf.pp1.ast.MulOpMultiply;
import rs.ac.bg.etf.pp1.ast.MultiCondFact;
import rs.ac.bg.etf.pp1.ast.MultiExpressionlist;
import rs.ac.bg.etf.pp1.ast.MultiVarDeclarationList;
import rs.ac.bg.etf.pp1.ast.NeqRelop;
import rs.ac.bg.etf.pp1.ast.NonEmptyReturnStatement;
import rs.ac.bg.etf.pp1.ast.NonExistingOptionalStatement;
import rs.ac.bg.etf.pp1.ast.NonExistingOptionalVarDeclList;
import rs.ac.bg.etf.pp1.ast.OptionalOptionalActParsNotExist;
import rs.ac.bg.etf.pp1.ast.OptionalVarDeclList;
import rs.ac.bg.etf.pp1.ast.Or;
import rs.ac.bg.etf.pp1.ast.PlusAddOp;
import rs.ac.bg.etf.pp1.ast.PrintStatementWithNumConst;
import rs.ac.bg.etf.pp1.ast.PrintStatementWithoutNumConst;
import rs.ac.bg.etf.pp1.ast.ProgramName;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.Relop;
import rs.ac.bg.etf.pp1.ast.SingleCondFact;
import rs.ac.bg.etf.pp1.ast.SingleCondTermList;
import rs.ac.bg.etf.pp1.ast.SingleExpressionList;
import rs.ac.bg.etf.pp1.ast.SingleVarDeclarationList;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.TermMultiFactor;
import rs.ac.bg.etf.pp1.ast.Then;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VarDeclaration;
import rs.ac.bg.etf.pp1.ast.VarDeclarationElem;
import rs.ac.bg.etf.pp1.ast.VarDeclarationList;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.While;
import rs.ac.bg.etf.pp1.ast.WhileCond;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	private int mainPc;
	
	int jmpOffset = 0;
	
	private int lenPc = 0;
	
	private int ordPc = 0;
	
	private int chrPc = 0;
	
	private boolean isNegativeOperand = false;
	
	Stack<List<Integer>> trueConditionJump = new Stack<>();
	Stack<List<Integer>> falseToNextCondtion = new Stack<>();
	Stack<List<Integer>> jumpOverElse = new Stack<>();
	
	Stack<Integer> whileStart = new Stack<Integer>();
	Stack<Integer> whileEnd = new Stack<Integer>(); 
	Stack<List<Integer>> breakConditions = new Stack<>();
	Stack<List<Integer>> continueConditions = new Stack<>(); 
	Stack<Integer> doAdresses = new Stack<Integer>();
	boolean doStatement = false;
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(ProgramName progName) {
		lenPc = Code.pc;
		
		Code.put(Code.enter);
		Code.put(1);
		Code.put(0);
		
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		
		
		ordPc = Code.pc; 
		
		Code.put(Code.enter);
		Code.put(1);
		Code.put(0);
		
		Code.put(Code.load_n);
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		chrPc = Code.pc;
		
		Code.put(Code.enter);
		Code.put(1);
		Code.put(0);
		
		Code.put(Code.load_n);
		
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(Do doStart) {
		trueConditionJump.push(new ArrayList<Integer>());
		falseToNextCondtion.push(new ArrayList<Integer>());
		breakConditions.push(new ArrayList<Integer>());
		continueConditions.push(new ArrayList<Integer>());
		
		doStatement = true;
		whileStart.push(Code.pc);
	}
	
	public void visit(WhileCond whileCond) {
	}
	
	
	public void visit(DoStatement doStatement) {
		Code.putJump(whileStart.peek().intValue());
		
		for (Integer value : falseToNextCondtion.peek())
			Code.fixup(value.intValue());
		
		for (Integer value : breakConditions.peek())
			Code.fixup(value.intValue());
		
		this.doStatement = false;
		
		whileStart.pop();
		trueConditionJump.pop();
		falseToNextCondtion.pop();
		breakConditions.pop();
		continueConditions.pop();
	}
	
	public void visit(While whileCond) {
		for (Integer value : continueConditions.peek())
			Code.fixup(value.intValue());
	}
	
	public void visit(ContinueStm continueStm) {
		Code.putJump(0);
		continueConditions.peek().add(Code.pc -2);
	}
	
	public void visit(BreakStm breakStm) {
		Code.putJump(0);
		breakConditions.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(IfStart start) {
		trueConditionJump.push(new ArrayList<Integer>());
		falseToNextCondtion.push(new ArrayList<Integer>());
		jumpOverElse.push(new ArrayList<Integer>());
	}
	
	@Override
	public void visit(FactorNumConst factor) {
		Integer constantValue = factor.getN1();
		Code.load(new Obj(Obj.Con, "$", Tab.intType, constantValue, 0));
	}
	
	@Override 
	public void visit(FactorCharConst factor) {
		Character constantValue = factor.getC1().charAt(1);
		Code.load(new Obj(Obj.Con, "$", Tab.charType, constantValue, 0));
	}
	
	@Override
	public void visit(FactorBoolConst factor) {
		boolean constantValue = factor.getB1();
		
		int value = constantValue == true ? 1 : 0; 
		
		Code.load(new Obj(Obj.Con, "$", Tab.find("bool").getType(),value,0));
	}
	
	private int getJmpOp(Relop op) {
		if (op instanceof EqRelop)
			return Code.eq;
		if (op instanceof NeqRelop)
			return Code.ne;
		if (op instanceof LtRelop)
			return Code.lt;
		if (op instanceof LteRelop)
			return Code.le;
		if (op instanceof GtRelop)
			return Code.gt;
		if (op instanceof GteRelop)
			return Code.ge;
		
		return Code.ne;
	}
	
	@Override
	public void visit(SingleCondFact condFact) {
		Code.loadConst(1);
		Code.putFalseJump(Code.eq, 0);
	    falseToNextCondtion.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(MultiCondFact condFact) {
		Code.putFalseJump(getJmpOp(condFact.getRelop()), 0);
		falseToNextCondtion.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(Or or) {
		if (doStatement == true)
			Code.putJump(whileStart.peek().intValue());
		else
			Code.putJump(0);
		trueConditionJump.peek().add(Code.pc - 2);
		
		for (Integer value : falseToNextCondtion.peek())
			Code.fixup(value.intValue());
		
		falseToNextCondtion.pop();
		falseToNextCondtion.push(new ArrayList<Integer>());
	}
	
	@Override
	public void visit(Then then) {
		for (Integer value : trueConditionJump.peek())
			Code.fixup(value.intValue());
	}
	
	@Override
	public void visit(IfStatement ifStatement) {
		trueConditionJump.pop();
		falseToNextCondtion.pop();
		jumpOverElse.pop();
	}
	
	@Override
	public void visit(IfThenPart part) {
		if (!(((IfStatement) part.getParent()).getOptionalElse() instanceof NonExistingOptionalStatement))
		{
			Code.putJump(0);
		    jumpOverElse.peek().add(Code.pc - 2);
		}
		
		for (Integer value : falseToNextCondtion.peek())
			Code.fixup(value.intValue());
	}
	
	@Override 
	public void visit(ExistingOptionalElse elseStm) {
		for (Integer value : jumpOverElse.peek())
			Code.fixup(value.intValue());
	}
	
	
	@Override
	public void visit(MultiExpressionlist multiExpressionList) {
		if (multiExpressionList.getExpressionList().struct.getKind() == Struct.Array && multiExpressionList.getTerm().struct.getKind() == Struct.Array && multiExpressionList.getAddOp() instanceof AddOp) {
			Struct tip = multiExpressionList.getExpressionList().struct;
			
			int loadCode = tip.getElemType() == Tab.intType ? Code.aload : Code.baload;
			int storeCode = tip.getElemType() == Tab.intType ? Code.astore : Code.bastore;
			int b = tip.getElemType() == Tab.intType ? 1 : 0;
			
			//prvi argument adresa prvog niza
			//drugi argument adresa drugog niza
			//treci argument duzina niza
			//cetvrti argument je adresa treceg niza
			//peti argument brojac 
			
			Code.put(Code.dup2);
			Code.put(Code.arraylength);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			Code.put(Code.arraylength);
			Code.putFalseJump(Code.ne, 0);
			int adr = Code.pc - 2;
			
			Code.put(Code.trap);
			Code.put(2);
			
			Code.fixup(adr);
			
			Code.put(Code.dup);
			Code.put(Code.arraylength);
			
			Code.put(Code.dup);
			Code.put(Code.newarray);
			Code.loadConst(b);
			Code.loadConst(0);
			 
			Code.put(Code.enter);
			Code.put(5);
			Code.put(0);
			
			int jumpPc = Code.pc;
			
			Code.put(Code.load_2);
			Code.put(Code.load);
			Code.put(5);
			
			Code.putFalseJump(Code.ne, 0);
			int fixupAdr = Code.pc - 2;
			
			Code.put(Code.load_n);
			Code.put(Code.load);
			Code.put(5);
			Code.put(loadCode);
			
			Code.put(Code.load_1);
			Code.put(Code.load);
			Code.put(5);
			Code.put(loadCode);
			
			Code.put(Code.add);
			
			Code.put(Code.load_3);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			
			Code.put(Code.load);
			Code.put(5);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			
			Code.put(storeCode);
			
			Code.put(Code.load);
			Code.put(5);
			Code.loadConst(1);
			Code.put(Code.add);
			
			Code.put(Code.store);
			Code.put(5);
			
			
			Code.putJump(jumpPc);		
			
			Code.fixup(fixupAdr);
			
			Code.put(Code.load_3);
			
			Code.put(Code.exit);
		} else {
		
			if (multiExpressionList.getAddOp() instanceof PlusAddOp)
				Code.put(Code.add);
			
			if (multiExpressionList.getAddOp() instanceof MinusAddOp)
				Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(TermMultiFactor multiFactor) {
		Struct prvi = multiFactor.getFactor().struct;
		Struct drugi = multiFactor.getTerm().struct;
		
		if (prvi.getKind() == Struct.Array && drugi.getKind() == Struct.Array && prvi.getElemType() == drugi.getElemType() && multiFactor.getMulOp() instanceof MulOpMultiply) {
			int loadCode = prvi.getElemType() == Tab.intType ? Code.aload : Code.baload;
			int storeCode = prvi.getElemType() == Tab.intType ? Code.astore : Code.bastore;
			int b = prvi.getElemType() == Tab.intType ? 1 : 0;
			
			//prvi argument adresa prvog niza
			//drugi argument adresa drugog niza
			//treci argument duzina niza
			//cetvrti argument je zbir
			//peti argument brojac
			
			Code.put(Code.dup2);
			Code.put(Code.arraylength);
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			Code.put(Code.arraylength);
			Code.putFalseJump(Code.ne, 0);
			int adr = Code.pc - 2;
			
			Code.put(Code.trap);
			Code.put(2);
			
			Code.fixup(adr);
			
			Code.put(Code.dup);
			Code.put(Code.arraylength);
			
			Code.loadConst(0);
			Code.loadConst(0);
			
			Code.put(Code.enter);
			Code.put(5);
			Code.put(0);
			
			int jumpPc = Code.pc; 
			
			Code.put(Code.load);
			Code.put(5);
			Code.put(Code.load_2);
		
			Code.putFalseJump(Code.ne, 0);
			int fixupAdr = Code.pc - 2;
			
			//ucitavamo prvi element na stek
			Code.put(Code.load_n);
			Code.put(Code.load);
			Code.put(5);
			Code.put(loadCode);
			
			//ucitavamo drugi element na stek
			Code.put(Code.load_1);
			Code.put(Code.load);
			Code.put(5);
			Code.put(loadCode);
			
			//mnozimo ih
			Code.put(Code.mul);
			
			//ucitavamo trenutni zbir
			Code.put(Code.load_3);
			
			//sabiramo
			Code.put(Code.add);
			
			//smestamo u rezultat
			Code.put(Code.store_3);
			
			//inkrementiramo brojac
			Code.put(Code.load);
			Code.put(5);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.put(Code.store);
			Code.put(5);
			
			
			Code.putJump(jumpPc);
			
			Code.fixup(fixupAdr);
			
			Code.put(Code.load_3);
			
			Code.put(Code.exit);
			
		} else {
			Struct second = multiFactor.getFactor().struct;
			Struct first = multiFactor.getTerm().struct;
			if ((multiFactor.getMulOp() instanceof MulOpMultiply) &&
			   (( first == Tab.charType && second.getKind() == Struct.Array && second.getElemType() == Tab.charType)
			   ||(first.getKind() == Struct.Array && first.getElemType() == Tab.charType && second == Tab.charType)
			   ||(first == Tab.intType && second.getKind() == Struct.Array && second.getElemType() == Tab.intType)
			   ||(first.getKind() == Struct.Array && first.getElemType() == Tab.intType && second == Tab.intType))) {
				
			   // pravimo situaciju da na steku imamo prvo adresu skalara pa adresu niza
			   if (first.getKind() == Struct.Array) {
				   Code.put(Code.dup_x1);
				   Code.put(Code.pop);
			   }
			   
			   Struct type = first.getKind() == Struct.Array ? first.getElemType() : first;
			   
			   int loadInstr = type == Tab.intType ? Code.aload : Code.baload;
			   int storeInstr = type == Tab.intType ? Code.astore : Code.bastore;
			   int b = type == Tab.intType ? 1 : 0;
			   // dohvatamo duzinu niza
			   Code.put(Code.dup);
			   Code.put(Code.arraylength);
			   
			   //alociramo novi niz
			   Code.put(Code.dup);
			   Code.put(Code.newarray);
			   Code.loadConst(b);
			   Code.loadConst(0);
				
			   //0. adresa skalara
			   //1. adresa niza
			   //2. duzina niza
			   //3. adresa novog niza
			   //4. index 
			   
			   Code.put(Code.enter);
			   Code.put(5);
			   Code.put(0);
				
			   int jumpPc = Code.pc; 
			   
			   Code.put(Code.load_2);
			   Code.put(Code.load);
			   Code.put(5);
				
			   Code.putFalseJump(Code.ne, 0);
			   int fixupAdr = Code.pc - 2;
				
			   
			   //ucitavamo skalar 
			   Code.put(Code.load_n);
			   //ucitavamo element niza
			   Code.put(Code.load_1);
			   Code.put(Code.load);
			   Code.put(5);
			   Code.put(loadInstr);
			   //mnozimo ih
			   Code.put(Code.mul);
			   
			   //Ucitavamo adresu niza
			   Code.put(Code.load_3);
			   Code.put(Code.dup_x1);
			   Code.put(Code.pop);
			   
			   //Ucitavamo indeks niza
			   Code.put(Code.load);
			   Code.put(5);
			   Code.put(Code.dup_x1);
			   Code.put(Code.pop);
			   
			   //Smestamo vrednost u niz
			   Code.put(storeInstr);
				
			   //inkrementiramo index
			   Code.put(Code.load);
			   Code.put(5);
			   Code.loadConst(1);
			   Code.put(Code.add);
			   Code.put(Code.store);
			   Code.put(5);
			
				
			   Code.putJump(jumpPc);		
				
			   Code.fixup(fixupAdr);
			   
			   Code.put(Code.load_3);
			   
			   Code.put(Code.exit);
			} else {
				if (multiFactor.getMulOp() instanceof MulOpMultiply)
					Code.put(Code.mul);
				if (multiFactor.getMulOp() instanceof MulOpDivide)
					Code.put(Code.div);
				if (multiFactor.getMulOp() instanceof MulOpMod)
					Code.put(Code.rem);
			}
		}
	}
	
	
	@Override
	public void visit(SingleExpressionList singleExpression) {
		SyntaxNode parentNode = singleExpression.getParent();
		while(parentNode != null && (parentNode instanceof Expression) == false)
			parentNode = parentNode.getParent();
		if (parentNode != null && (((Expression)parentNode).getOptionalMinus() instanceof ExistingOptionalMinus))
			Code.put(Code.neg);
	}
	
	@Override
	public void visit(IncDesignatorStatement incr) {
		Obj objekat = incr.getDesignator().obj;
		
		if (objekat.getKind() != Obj.Elem) {
			Code.load(objekat);
			Code.loadConst(1);
			Code.put(Code.add);
		} else {
			Code.put(Code.dup2);
			Code.load(objekat);
			Code.loadConst(1);
			Code.put(Code.add);
		}
		Code.store(objekat);
	}
	
	@Override
	public void visit(DecDesignatorStatement decr) {
		Obj objekat = decr.getDesignator().obj;
		
		if (objekat.getKind() != Obj.Elem) {
			Code.load(objekat);
			Code.loadConst(1);
			Code.put(Code.sub);
		} else {
			Code.put(Code.dup2);
			Code.load(objekat);
			Code.loadConst(1);
			Code.put(Code.sub);
		}
		Code.store(objekat);
	}
	
	
	@Override
	public void visit(DesignatorAssignExpress assignExpression) {
		Obj objekat = assignExpression.getDesignator().obj;	
		Code.store(objekat);
	}
	
	@Override
	public void visit(ActParsDesignatorStatement statement) {
		String name = ((DesignatorIdent)statement.getDesignator().getDesignatorAllList()).getI1();
		if (name.equals("len"))
		{
			Code.put(Code.arraylength);
			System.out.println("Pozvana len metoda  - stavljen arraylength");
		} 
		else 
		{
			Code.put(Code.call);
			int src = statement.getDesignator().obj.getAdr();
			if (name.equals("len")) {
				src = lenPc;
				System.out.println("Ovo nece da ti radi");
			}
			if (name.equals("ord"))
				src = ordPc;
			if (name.equals("chr"))
				src = chrPc;
			int offset = src - Code.pc + 1;
			Code.put2(offset);
			if (statement.getDesignator().obj.getType() != Tab.noType) {
				Code.put(Code.pop);
			}
		}
	}
	
	@Override
	public void visit(FactorDesignator factor) {
		if (factor.getOptionalOptionalActPars() instanceof OptionalOptionalActParsNotExist) {
			Code.load(factor.getDesignator().obj);
		} else {
			String name = ((DesignatorIdent)factor.getDesignator().getDesignatorAllList()).getI1();
			if (name.equals("len")) {
				Code.put(Code.arraylength);
			} else {
				Code.put(Code.call);
				int src = factor.getDesignator().obj.getAdr();
				
				if (name.equals("ord"))
					src = ordPc;
				if (name.equals("chr"))
					src = chrPc;
				int offset = src - Code.pc + 1;
				Code.put2(offset);
			}
		}
	}
	
	@Override
	public void visit(ReadStatement readStatement) {
		if (readStatement.getDesignator().obj.getType() == Tab.charType) {
		    Code.put(Code.bread); 
		} else {
			Code.put(Code.read);
		}
		Code.store(readStatement.getDesignator().obj);
	}

	@Override
	public void visit(MethodName methodName) {
		String name = methodName.getMethodName();	
		if ("main".equalsIgnoreCase(name))
		{
			mainPc = Code.pc;
		}
		methodName.obj.setAdr(Code.pc);
		System.out.println("method pc " + Code.pc);
		
		Code.put(Code.enter);
		Code.put(methodName.obj.getLevel());
		int numberOfLocalVariables = getNumberOfLocalVariables(methodName);
		Code.put(numberOfLocalVariables);
	}
	
	@Override
	public void visit(MethodDeclaration declaration) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(PrintStatementWithoutNumConst printStm) {
		if (printStm.getExpression().struct == Tab.charType) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		} else {
			Code.loadConst(5);
			Code.put(Code.print);
		}
	} 
	
	@Override
	public void visit(PrintStatementWithNumConst printStm) {
		Code.loadConst(printStm.getN2().intValue());
		if (printStm.getExpression().struct == Tab.charType) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(EmptyReturnStatement statement) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(NonEmptyReturnStatement statement) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(FactorNewTypeWithExpr factor) {
		Code.put(Code.newarray);
		
		if(factor.getType().struct != Tab.charType)
		{
			Code.loadConst(1);
		}
		else
		{
			Code.loadConst(0);
		}
	}
	
	@Override
	public void visit(ArrayOrClassName arrayName) {
		Code.load(arrayName.obj);
	}
	
	public int getNumberOfLocalVariables(MethodName methodName) {
		MethodDeclaration declaration = (MethodDeclaration) methodName.getParent();
		OptionalVarDeclList list = declaration.getOptionalVarDeclList();
		int result = 0;
		if (list instanceof NonExistingOptionalVarDeclList) {
			return 0;
		} else {
			OptionalVarDeclList existingList = list;
			while(existingList != null && (existingList instanceof ExistingOptionalVarDeclList)) {
				result += getLocalVars(((ExistingOptionalVarDeclList)existingList).getVarDeclaration());
				existingList = ((ExistingOptionalVarDeclList) existingList).getOptionalVarDeclList();
			}
			return result;
		}
	}
	
	private int getLocalVars(VarDeclaration varDeclaration) {
		int result = 0;
		VarDeclarationList list = varDeclaration.getVarDeclarationList();
		if (list instanceof SingleVarDeclarationList) {
			return 1;
		} else {
			while(list != null && (list instanceof MultiVarDeclarationList)) {
				result += 1;
				list = ((MultiVarDeclarationList) list).getVarDeclarationList();
			}
			if (list != null)
				result += 1;
			return result;
		}
	}
	
	public String findName(Designator designator) {
		if (designator.getDesignatorAllList() instanceof DesignatorIdent) {
			return ((DesignatorIdent) designator.getDesignatorAllList()).getI1();
		} else {
			return ((DesignatorArrayOrClass) designator.getDesignatorAllList()).getArrayOrClassName().getArrayClassName();
		}
	}
}
