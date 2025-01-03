import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

abstract public class CustomInterpreter {
    private IDE app;
    private Listener listener;
    private int delay;
    private boolean executingCompiled;
    public CustomInterpreter () {}
    abstract void SET (String RD, int imm);
    abstract void INC (String RD, int imm);
    abstract void LTI (String RS, int imm);
    abstract void GTI (String RS, int imm);
    abstract void EQI (String RS, int imm);
    abstract void ADD (String RS, String RT, String RD);
    abstract void LES (String RS, String RT);
    abstract void GRT (String RS, String RT);
    abstract void EQV (String RS, String RT);
    abstract void ORR (String RS, String RT);
    abstract void AND (String RS, String RT);
    abstract void RTN ();
    abstract void JNC (int imm);
    abstract void JWC (int imm);
    abstract void CPT (int imm);
    abstract void SAV (String RS, int offset, String RT);
    abstract void LOD (String RD, int offset, String RS);
    abstract void SWAP (String RS, String RT);
    abstract void CAST (String RD);
    abstract void PARS (String RD);
    abstract void PRNT (String RS);
    abstract void PLAY (String RS);
    abstract void DISP (String RS);
    abstract void MFPK (String RD);
    abstract void TIME (String RD);
    abstract void CCAT (String RS, String RT, String RD);
    abstract void ALOC (int imm);
    abstract void PACK (String RS, String RT, int offset);
    abstract public void run ();
    abstract void update ();
    abstract void executeInstructions (String[] instructions);
    abstract void executeInstruction (String instruction);
    abstract void executeInstructionFromSpecial (String instruction);
    abstract int parseSigned (String asciiBin);
    abstract int parseOffset (String asciiBin);
    abstract int parseUnsigned (String value);
    abstract int[] getNullTerminated (int address);
    abstract String intToAsciiBin (int value);
    abstract public void setInstructionDelay (int delay);
}
