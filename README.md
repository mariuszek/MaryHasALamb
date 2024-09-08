
Converts the plain text with statements into XML or CVS output.

    Usage: [options] [args...]
        where options include:
        -xml XML type of output will be produced Default -xml option.
        -csv CSV type of output will be produced.
        -f <file> input file that will be used to produce output. File must exist. Default Std in is used
            Example: -f ./src/test/resources/small.in
                        
        -o <file> output file that will be used. The output file will be erased if exists without a warning. 
            Default Std out is used.How To
Features:
1. Low memory consumption (Large.in) with -Xmx32m on utilized ~ 16MB of memory
2. With low memory testes over extraLarge data producing 4 849 153 sentences -> "Sentence 4849153, end, friend, is, my, the, This"
2. Able to read/write to STD in/out
3. Able to read/write to selected files 
4. Contains -h option printing basic usage
5. Able to produce both xml and csv output
6. Written by old timer with rusty code skills :)

Known limitations:
1. Due to low memory requirement, code is not thread safe. 
2. The Memory limitation implies limits in building the header of csv file.
3. Written using JDK 21. But features should be working fine starting from JDK 11 (not tested)
4. CLI has basic verification sufficient for usage.
