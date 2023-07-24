package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.feature.configuration.SeaRockConfiguration;

public class SeaRockFeature extends Feature<SeaRockConfiguration> {
        public SeaRockFeature(Codec<SeaRockConfiguration> p_66017_) {
            super(p_66017_);
        }

        public boolean place(FeaturePlaceContext<SeaRockConfiguration> p_159884_) {
            BlockPos blockpos = p_159884_.origin();
            WorldGenLevel worldgenlevel = p_159884_.level();
            blockpos = new BlockPos(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            if(worldgenlevel.getBlockState(blockpos.below()).is(Blocks.PACKED_ICE)){
                return false;
            }
            RandomSource randomsource = p_159884_.random();
            if(randomsource.nextInt(2)==0){
                return false;
            }
            boolean flag = randomsource.nextDouble() > 0.7D;
            BlockState blockstate = (p_159884_.config()).state;
            BlockState blockstateAlt = (p_159884_.config()).altState;
            double d0 = randomsource.nextDouble() * 2.0D * Math.PI;
            int i = 11 - randomsource.nextInt(5);
            int j = 3 + randomsource.nextInt(3);
            boolean flag1 = randomsource.nextDouble() > 0.7D;
            int k = 11;
            int l = flag1 ? randomsource.nextInt(6) + 6 : randomsource.nextInt(15) + 3;
            if (!flag1 && randomsource.nextDouble() > 0.9D) {
                l += randomsource.nextInt(19) + 7;
            }

            int i1 = Math.min(l + randomsource.nextInt(11), 18);
            int j1 = Math.min(l + randomsource.nextInt(7) - randomsource.nextInt(5), 11);
            int k1 = flag1 ? i : 11;

            for(int l1 = -k1; l1 < k1; ++l1) {
                for(int i2 = -k1; i2 < k1; ++i2) {
                    for(int j2 = 0; j2 < l; ++j2) {
                        int k2 = flag1 ? this.heightDependentRadiusEllipse(j2, l, j1) : this.heightDependentRadiusRound(randomsource, j2, l, j1);
                        if (flag1 || l1 < k2) {
                            this.generateIcebergBlock(worldgenlevel, randomsource, blockpos, l, l1, j2, i2, k2, k1, flag1, j, d0, flag, blockstate, blockstateAlt);
                        }
                    }
                }
            }

            this.smooth(worldgenlevel, blockpos, j1, l, flag1, i);

            for(int i3 = -k1; i3 < k1; ++i3) {
                for(int j3 = -k1; j3 < k1; ++j3) {
                    for(int k3 = -1; k3 > -i1; --k3) {
                        int l3 = flag1 ? Mth.ceil((float)k1 * (1.0F - (float)Math.pow((double)k3, 2.0D) / ((float)i1 * 8.0F))) : k1;
                        int l2 = this.heightDependentRadiusSteep(randomsource, -k3, i1, j1);
                        if (i3 < l2) {
                            this.generateIcebergBlock(worldgenlevel, randomsource, blockpos, i1, i3, k3, j3, l2, l3, flag1, j, d0, flag, blockstate, blockstateAlt);
                        }
                    }
                }
            }

            boolean flag2 = flag1 ? randomsource.nextDouble() > 0.1D : randomsource.nextDouble() > 0.7D;
            if (flag2) {
            }

            return true;
        }

        private void generateIcebergBlock(LevelAccessor p_225110_, RandomSource p_225111_, BlockPos p_225112_, int p_225113_, int p_225114_, int p_225115_, int p_225116_, int p_225117_, int p_225118_, boolean p_225119_, int p_225120_, double p_225121_, boolean p_225122_, BlockState p_225123_, BlockState p_225123_1) {
            double d0 = p_225119_ ? this.signedDistanceEllipse(p_225114_, p_225116_, BlockPos.ZERO, p_225118_, this.getEllipseC(p_225115_, p_225113_, p_225120_), p_225121_) : this.signedDistanceCircle(p_225114_, p_225116_, BlockPos.ZERO, p_225117_, p_225111_);
            if (d0 < 0.0D) {
                BlockPos blockpos = p_225112_.offset(p_225114_, p_225115_, p_225116_);
                double d1 = p_225119_ ? -0.5D : (double)(-6 - p_225111_.nextInt(3));
                if (d0 > d1 && p_225111_.nextDouble() > 0.9D) {
                    return;
                }

                this.setIcebergBlock(blockpos, p_225110_, p_225111_, p_225113_ - p_225115_, p_225113_, p_225119_, p_225122_, p_225123_, p_225123_1);
            }

        }

        private void setIcebergBlock(BlockPos p_225125_, LevelAccessor p_225126_, RandomSource p_225127_, int p_225128_, int p_225129_, boolean p_225130_, boolean p_225131_, BlockState p_225132_, BlockState p_225132_1) {
            BlockState blockstate = p_225126_.getBlockState(p_225125_);
            if (blockstate.isAir() || blockstate.is(Blocks.SNOW_BLOCK) || blockstate.is(Blocks.ICE) || p_225126_.getFluidState(p_225125_).is(Fluids.WATER)) {
                boolean flag = !p_225130_ || p_225127_.nextDouble() > 0.05D;
                int i = p_225130_ ? 3 : 2;
                if (p_225131_ && (double)p_225128_ <= (double)p_225127_.nextInt(Math.max(1, p_225129_ / i)) + (double)p_225129_ * 0.6D && flag) {
                    this.setBlock(p_225126_, p_225125_, p_225132_1);
                } else {
                    if(p_225127_.nextInt(4)==0){
                        this.setBlock(p_225126_, p_225125_, p_225132_1);
                    }
                    this.setBlock(p_225126_, p_225125_, p_225132_);
                }
            }

        }

        private int getEllipseC(int p_66019_, int p_66020_, int p_66021_) {
            int i = p_66021_;
            if (p_66019_ > 0 && p_66020_ - p_66019_ <= 3) {
                i = p_66021_ - (4 - (p_66020_ - p_66019_));
            }

            return i;
        }

        private double signedDistanceCircle(int p_225089_, int p_225090_, BlockPos p_225091_, int p_225092_, RandomSource p_225093_) {
            float f = 10.0F * Mth.clamp(p_225093_.nextFloat(), 0.2F, 0.8F) / (float)p_225092_;
            return (double)f + Math.pow((double)(p_225089_ - p_225091_.getX()), 2.0D) + Math.pow((double)(p_225090_ - p_225091_.getZ()), 2.0D) - Math.pow((double)p_225092_, 2.0D);
        }

        private double signedDistanceEllipse(int p_66023_, int p_66024_, BlockPos p_66025_, int p_66026_, int p_66027_, double p_66028_) {
            return Math.pow(((double)(p_66023_ - p_66025_.getX()) * Math.cos(p_66028_) - (double)(p_66024_ - p_66025_.getZ()) * Math.sin(p_66028_)) / (double)p_66026_, 2.0D) + Math.pow(((double)(p_66023_ - p_66025_.getX()) * Math.sin(p_66028_) + (double)(p_66024_ - p_66025_.getZ()) * Math.cos(p_66028_)) / (double)p_66027_, 2.0D) - 1.0D;
        }

        private int heightDependentRadiusRound(RandomSource p_225095_, int p_225096_, int p_225097_, int p_225098_) {
            float f = 3.5F - p_225095_.nextFloat();
            float f1 = (1.0F - (float)Math.pow((double)p_225096_, 2.0D) / ((float)p_225097_ * f)) * (float)p_225098_;
            if (p_225097_ > 15 + p_225095_.nextInt(5)) {
                int i = p_225096_ < 3 + p_225095_.nextInt(6) ? p_225096_ / 2 : p_225096_;
                f1 = (1.0F - (float)i / ((float)p_225097_ * f * 0.4F)) * (float)p_225098_;
            }

            return Mth.ceil(f1 / 2.0F);
        }

        private int heightDependentRadiusEllipse(int p_66110_, int p_66111_, int p_66112_) {
            float f = 1.0F;
            float f1 = (1.0F - (float)Math.pow((double)p_66110_, 2.0D) / ((float)p_66111_ * 1.0F)) * (float)p_66112_;
            return Mth.ceil(f1 / 2.0F);
        }

        private int heightDependentRadiusSteep(RandomSource p_225134_, int p_225135_, int p_225136_, int p_225137_) {
            float f = 1.0F + p_225134_.nextFloat() / 2.0F;
            float f1 = (1.0F - (float)p_225135_ / ((float)p_225136_ * f)) * (float)p_225137_;
            return Mth.ceil(f1 / 2.0F);
        }

        private static boolean isRockState(BlockState p_159886_) {
            return p_159886_.is(Blocks.STONE) || p_159886_.is(RuBlocks.MOSSY_STONE.get()) || p_159886_.is(Blocks.PACKED_ICE)|| p_159886_.is(Blocks.MOSS_BLOCK);
        }

        private boolean belowIsAir(BlockGetter p_66046_, BlockPos p_66047_) {
            return p_66046_.getBlockState(p_66047_.below()).isAir()||p_66046_.getFluidState(p_66047_.below()).is(Fluids.WATER);
        }

        private void smooth(LevelAccessor level, BlockPos p_66053_, int p_66054_, int p_66055_, boolean p_66056_, int p_66057_) {
            int i = p_66056_ ? p_66057_ : p_66054_ / 2;

            for(int j = -i; j <= i; ++j) {
                for(int k = -i; k <= i; ++k) {
                    for(int l = 0; l <= p_66055_; ++l) {
                        BlockPos blockpos = p_66053_.offset(j, l, k);
                        BlockState blockstate = level.getBlockState(blockpos);
                        if (isRockState(blockstate) || blockstate.is(Blocks.SNOW)) {
                            if (this.belowIsAir(level, blockpos)) {
                                if(blockpos.getY()>=level.getSeaLevel()){
                                    this.setBlock(level, blockpos, Blocks.AIR.defaultBlockState());
                                }
                                else{
                                    this.setBlock(level, blockpos, Blocks.WATER.defaultBlockState());
                                }

                                if(blockpos.above().getY()>=level.getSeaLevel()){
                                this.setBlock(level, blockpos.above(), Blocks.AIR.defaultBlockState());
                                }
                                else{
                                    this.setBlock(level, blockpos.above(), Blocks.WATER.defaultBlockState());
                                }
                            } else if (isRockState(blockstate)) {
                                BlockState[] ablockstate = new BlockState[]{level.getBlockState(blockpos.west()), level.getBlockState(blockpos.east()), level.getBlockState(blockpos.north()), level.getBlockState(blockpos.south())};
                                int i1 = 0;

                                for(BlockState blockstate1 : ablockstate) {
                                    if (!isRockState(blockstate1)) {
                                        ++i1;
                                    }
                                }

                                if (i1 >= 3) {
                                    if(blockpos.getY()>=level.getSeaLevel()){
                                        this.setBlock(level, blockpos, Blocks.AIR.defaultBlockState());
                                    }
                                    else{
                                        this.setBlock(level, blockpos, Blocks.WATER.defaultBlockState());
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
