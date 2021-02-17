package blockchain;

import java.util.Date;

public class Main {

    private static class Block
    {
        private final int id;
        private final long timeStamp;
        private final String prevHash;
        private final String hash;
        Block(int id, String prevHash)
        {
            this.id = id;
            this.prevHash = prevHash;
            timeStamp = new Date().getTime();
            hash = StringUtil.applySha256(id+timeStamp+prevHash);

        }
        public int getId()
        {
            return id;
        }
        public long getTimeStamp()
        {
            return timeStamp;
        }
        public String getPrevHash()
        {
            return prevHash;
        }
        public String getHash()
        {
            return hash;
        }
    }
    private static class Chain
    {
        private Block chain[];
        private int size;
        Chain(int size)
        {
            this.size = size;
            chain = new Block[size];
        }
        public void addBlock(int id)
        {
            if( id == 1)
            {
                chain[0] = new Block(1,"0");
            }
            else
            {
                String prevHash = chain[id - 2].getHash();
                chain[id-1] = new Block(id,prevHash);
            }
        }

        public Block getBlock(int id)
        {
            return chain[id-1];
        }

        @Override
        public String toString()
        {
            StringBuilder str = new StringBuilder();
                for( int i = 0 ; i < chain.length ; i++)
                {
                    if(chain[i] != null)
                    {
                        str.append("Block:\n"+"Id: "+chain[i].getId()+"\n"+"Timestamp: "+chain[i].getTimeStamp()+"\n"+"Hash of the previous block:\n"+chain[i].getPrevHash()+"\n"+"Hash of the block:\n"+chain[i].getHash());
                    }
                    if(i < chain.length-1)
                        str.append("\n\n");
                }
            return str.toString();
        }

    }
    public static void main(String[] args)
    {
        Chain blockchain = new Chain(5);
        for(int i  = 1 ; i < 6 ; i++)
            blockchain.addBlock(i);
        System.out.println(blockchain);
    }
}
