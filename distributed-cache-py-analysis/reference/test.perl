#!/usr/bin/env perl
use warnings;
use strict;
use Text::CSV_XS;
use autodie;
my $csv = Text::CSV_XS->new();
open my $FH, "<", "file.txt";
while (<$FH>) {
    $csv->parse($_);
    my @fields = $csv->fields;
    print "test";

}
